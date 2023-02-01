package intermediate_promote.class02;

public class Code06_MaxLength {

    //给定一个由左右括号组成的字符串，找到最长有效的括号子串，子串是连续的。
    public static int maxLength(String str) {
        if (str == null || str.length() < 2) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int n = str.length();
        int[] dp = new int[n]; //dp[i]表示i位置上为终点的，最长的子串(从右向左)
        int pre = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (chs[i] == ')') { //遇到'('为0，所以不考虑
                pre = i - dp[i - 1] - 1; //与Str[i]配对的左括号的位置pre
                if (pre >= 0 && chs[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "((()))()";
        int i = maxLength(str);
        System.out.println(i);
    }

}
