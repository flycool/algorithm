package intermediate_promote.class08;

public class Code05_EditCost {

    //给定两个字符串str1和str2，三个整数ic，dc和rc，代表插入，删除和替换一个字符串的代价，
    //返回将str1编辑成str2的最小代价。
    public static int minCost(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int row = chars1.length + 1;
        int col = chars2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;//第一行
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = ic * i;//第1列
        }
        for (int i = 1; i <row; i++) {
            for (int j = 1; j < col; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);//dp[i]-->dp[j-1]，差一个dp[j], 所以加一个 ic
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + dc);//dp[i-1]-->[j],多了个dp[i],所以减一个 dc
            }
        }
        return dp[row - 1][col - 1];
    }
}
