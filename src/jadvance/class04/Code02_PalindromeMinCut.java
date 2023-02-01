package jadvance.class04;

public class Code02_PalindromeMinCut {

    /*
        给定一个字符串str，返回把str全部切成回文子串的最小分割数
     */
    public static int minParts(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        return process(s.toCharArray(), 0);
    }

    private static int process(char[] chars, int i) {
        if (i == chars.length) {
            return 0;
        }
        int len = chars.length;
        int ans = Integer.MAX_VALUE;
        for (int end = i; end < len; end++) {//O(N^2)
            //判断chars[i..end]是否回文
            if (valid(chars, i, end)) {
                ans = Math.min(ans, 1 + process(chars, end + 1));
            }
        }
        return ans;
    }

    //要遍历吗？可优化
    private static boolean valid(char[] chars, int l, int r) {
        return false;
    }

    //============================
    public static int minCutDp(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[] dp = new int[len + 1];
        dp[len] = 0;
        dp[len - 1] = 1;
        boolean[][] p = record(chs);
        for (int i = len - 2; i >= 0; i--) {//从右往左填表
            dp[i] = len - i;
            for (int j = i; j < len; j++) {
                if (p[i][j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    private static boolean[][] record(char[] chs) {
        int len = chs.length;
        boolean[][] record = new boolean[len][len];
        record[len - 1][len - 1] = true;
        for (int i = 0; i < len - 1; i++) {
            record[i][i] = true;//对角线
            record[i][i + 1] = chs[i] == chs[i + 1];
        }
        for (int row = len - 3; row >= 0; row--) {//从下往上
            for (int col = row + 2; col < len; col++) {//从左往右
                //在chs[row] == chs[col] 相等的情况下，依赖左下角的值
                record[row][col] = chs[row] == chs[col] && record[row + 1][col - 1];
            }
        }
        return record;
    }

    public static void main(String[] args) {
        String s = "abcbdf";
        int i = minCutDp(s);
        System.out.println(i);
    }

}
