package interview2022;

/**
 * 51.布尔表达式的期待方法数
 * 给定一个长度为奇数的字符串
 * 字符串的偶数位置为0或1字符，奇数位置为逻辑运算符
 * 随意划分小括号，导致结果为true的方法数有多少种
 * 思路：
 * 以逻辑符号为最后结合的方法数的和
 */
public class Code51_BooleanEvaluation {

    public class Info {
        public int t;
        public int f;

        public Info(int t, int f) {
            this.t = t;
            this.f = f;
        }
    }

    public int countEval(String express, int desired) {
        int n = express.length();
        Info[][] dp = new Info[n][n];
        Info allInfo = func(express.toCharArray(), 0, express.length() - 1, dp);
        return desired == 1 ? allInfo.t : allInfo.f;
    }

    public Info func(char[] str, int l, int r, Info[][] dp) {
        if (dp[l][r]!=null) {
            return dp[l][r];
        }
        int t = 0, f = 0;
        if (l == r) {
            t = str[l] == '1' ? 1 : 0;
            f = str[l] == '0' ? 1 : 0;
            return new Info(t, f);
        } else {
            for (int split = l + 1; split < r; split += 2) {
                Info leftInfo = func(str, l, split - 1, dp);
                Info rightInfo = func(str, split + 1, r, dp);
                int a = leftInfo.t, b = leftInfo.f;
                int c = rightInfo.t, d = leftInfo.f;
                switch (str[split]) {
                    case '&':
                        t += a * c;
                        f += a * d + b * c + b * d;
                        break;
                    case '|':
                        t += a * c + a * d + b * c;
                        f += b * d;
                        break;
                    case '^':
                        t += a * d + b * c;
                        f += a * c + b * d;
                        break;
                }
            }
            dp[l][r] = new Info(t, f);
            return dp[l][r];
        }
    }
}
