package base_promote.class10_dp;

/**
 * 有个正数数组，无重复值，一个位置的值代表一个货币的面值，面值可选任意一张，
 * 有个钱数aim，找零，方法数有多少种
 */
public class Code05_CoinsWays {

    public static int coinsWays(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int num = 0; arr[index] * num <= rest; num++) {
            ways += process(arr, index + 1, rest - arr[index] * num);
        }
        return ways;
    }

    public static int coinsWaysDp(int[] arr, int rest) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][rest + 1];
        dp[n][0] = 1;
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col <= rest; col++) {
                int ways = 0;
                for (int num = 0; arr[row] * num <= rest; num++) {
                    ways += dp[row + 1][rest - arr[row] * num];
                }
                dp[row][col] = ways;
            }
        }
        return dp[0][rest];
    }

    //斜率优化
    public static int coinsWaysDp2(int[] arr, int rest) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][rest + 1];
        dp[n][0] = 1;
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col <= rest; col++) {
                dp[row][col] = dp[row + 1][col];
                if (rest - arr[row] >= 0) {
                    dp[row][col] += dp[row][rest - arr[row]];
                }
            }
        }
        return dp[0][rest];
    }
}
