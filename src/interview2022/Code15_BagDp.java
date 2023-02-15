package interview2022;

/**
 * 每一个货物有它的 体积和价值，有无穷多件
 * 给定一个limit体积
 * 返回能够达到的最大价值是多少
 * （无限背包问题）
 */
public class Code15_BagDp {

    public int[][] dp(int[] cost, int[] value, int m) {
        int n = cost.length;
        int[][] dp = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        for (int k = 1; cost[0] * k <= m; k++) {
            dp[0][cost[0] * k] = k * value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][i] = dp[i - 1][j];
                if (j - cost[i] >= 0 && dp[i][j - cost[i]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - cost[i]] + value[i]);
                }
            }
        }
        return dp;
    }
}
