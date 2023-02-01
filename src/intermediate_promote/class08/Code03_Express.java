package intermediate_promote.class08;

public class Code03_Express {

    public static boolean isValid(char[] exp) {
        if ((exp.length & 1) == 0) {//必须为奇数
            return false;
        }
        for (int i = 0; i < exp.length; i = i + 2) {
            if ((exp[i] != '0') && (exp[i] != '1')) {
                return false;
            }
        }
        for (int i = 1; i < exp.length; i = i + 2) {
            if ((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')) {
                return false;
            }
        }
        return true;
    }

    //给定一个由 0(false),1(true),&,|,^ 5种字符组成的字符串express，和一个boolean desired。
    //返回express能有多少种组合方式，可以达到desired的结果
    public static int num1(String str, boolean desired) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] exp = str.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    //L, R 不能压中逻辑符号
    private static int p(char[] exp, boolean desired, int L, int R) {
        if (L == R) {
            if (exp[L] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = L + 1; i < R; i += 2) {
                switch (i) {
                    case '&':
                        //符号的两边递归
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                        break;
                    case '|':
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        break;
                    case '^'://异或，不相同为true
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        break;
                }
            }
        } else {
            for (int i = L + 1; i < R; i += 2) {
                switch (i) {
                    case '&':
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                        break;
                    case '|':
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                        break;
                    case '^':
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                        break;
                }
            }
        }
        return res;
    }

}
