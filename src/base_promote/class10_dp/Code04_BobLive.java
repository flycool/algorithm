package base_promote.class10_dp;

/**
 * n*m的区域，Bob在(row,col)位置出发，走rest步之后，的生存概率
 */
public class Code04_BobLive {

    public static String bobLive(int n, int m, int row, int col, int rest) {
        long all = (long) Math.pow(4, rest);
        long live = process(n, m, row, col, rest);
        long gcd = gcd(all, live);
        return (live / gcd) + "/" + (all / gcd);
    }

    //最大公约数
    private static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    //获得生存方法数
    private static long process(int n, int m, int row, int col, int rest) {
        if (row < 0 || row == n || col < 0 || col == m) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        return process(n, m, row + 1, col, rest - 1) +
                process(n, m, row - 1, col, rest - 1) +
                process(n, m, row, col + 1, rest - 1) +
                process(n, m, row, col - 1, rest - 1);
    }

    private static String bolLiveDp(int n, int m, int row, int col, int rest) {
        int[][][] dp = new int[row + 2][col + 2][rest + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < col; j++) {
                dp[row][col][0] = 1;
            }
        }

        for (int i = 0; i <= rest; i++) {
            for (int j = 0; j <= row; j++) {
                for (int k = 0; k <= col; k++) {
                    dp[j][k][i] = dp[j + 1][k][i - 1];
                    dp[j][k][i] = dp[j - 1][k][i - 1];
                    dp[j][k][i] = dp[j][k + 1][i - 1];
                    dp[j][k][i] = dp[j][k - 1][i - 1];
                }
            }
        }
        long all = (long) Math.pow(4, rest);
        long live = dp[row + 1][col + 1][rest];
        long gcd = gcd(all, live);
        return (live / gcd) + "/" + (all / gcd);
    }
}
