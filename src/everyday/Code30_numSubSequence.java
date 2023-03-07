package everyday;

/**
 * 30 微众银行
 * 给定一个数字n，代表数组的长度
 * 给定一个数字m，代表数组每个位置都可以在1~m之间选择数字
 * 所有长度为n的数组中，最长递增子序列长度为3的数组，叫做达标数组
 * 返回达标数组的数量
 * 1<=n<=500
 * 1<=m<=10
 * 500*10*10*10
 * 结果对998244353取模
 * 实现的时候没有取模的逻辑，因为非重点
 */
public class Code30_numSubSequence {

    public int number(int n, int m) {
        int[][][][] dp = new int[n][m + 1][m + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    for (int l = 0; l <= m; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        return f(0, 0, 0, 0, n, m, dp);
    }

    //first, second, third 为递增子序列计算得的三位
    public int f(int i, int first, int second, int third, int n, int m, int[][][][] dp) {
        if (i == n) {
            return third != 0 ? 1 : 0;
        }
        if (dp[i][first][second][third] != -1) {
            return dp[i][first][second][third];
        }
        int ans = 0;
        for (int cur = 1; cur <= m; cur++) {
            if (first == 0 || first >= cur) {
                ans += f(i + 1, cur, second, third, n, m, dp);
            } else if (second == 0 || second >= cur) {
                ans += f(i + 1, first, cur, third, n, m, dp);
            } else if (third == 0 || third >= cur) {
                ans += f(i + 1, first, second, cur, n, m, dp);
            }
        }
        dp[i][first][second][third] = ans;
        return ans;
    }
}
