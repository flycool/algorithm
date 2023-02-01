package jadvance.class04;

public class Code06_RegularExpressionMatch {

    public static boolean isValid(char[] s, char[] e) {
        if (s == null || e == null) {
            return false;
        }
        for (char c : s) {
            if (c == '*' || c == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return isValid(s, e) && process(s, e, 0, 0);
    }

    //保证ei不能压中*
    private static boolean process(char[] s, char[] e, int si, int ei) {
        if (ei == e.length) {//base case
            return si == s.length;
        }
        //1) ei+1 不是*
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (s[si] == e[ei] || e[ei] == '.') &&
                    process(s, e, si + 1, ei + 1);
        }
        //2) ei+1 是*
        while (si != s.length && (s[si] == e[ei] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }

    public static boolean isMatchDp(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s, e)) {
            return false;
        }
        boolean[][] dp = initDpMap(s, e);
        for (int i = s.length - 1; i > -1; i--) {
            for (int j = e.length - 2; j > -1; j--) {
                if (e[j + 1] != '*') {
                    dp[i][j] = (s[i] == e[j] || e[j] == '.') && dp[i + 1][j + 1];
                } else {
                    int si = i;
                    while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
                        if (dp[si][j + 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if (!dp[i][j]) {
                        dp[i][j] = dp[si][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    //初始化最右一行，和最右两列
    private static boolean[][] initDpMap(char[] s, char[] e) {
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = new boolean[slen + 1][elen + 1];
        dp[slen][elen] = true;
        for (int j = elen - 2; j > -1; j = j - 2) {
            if (e[j] != '*' && e[j + 1] != '*') {
                dp[slen][j] = true;//最右一行
            } else {
                break;
            }
        }
        if (slen > 0 && elen > 0) {
            if (e[elen - 1] == '.' || e[elen - 1] == s[slen - 1]) {
                dp[slen - 1][elen - 1] = true;
            }
            //别的为false
        }
        return dp;
    }

    public static void main(String[] args) {
        String str = "abcccdef";
        String exp = "ab.*d.*e.*";
        boolean match = isMatch(str, exp);
        boolean match2 = isMatchDp(str, exp);
        System.out.println(match);
        System.out.println(match2);
    }

}
