package base_promote.class10_dp;

public class Code02_CoinsMin {

    public static int coinsMin(int[] arr, int index, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int p1 = process(arr, index + 1, rest);//不选index位
        int p2 = process(arr, index + 1, rest - arr[index]);//选index位
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            } else if (p2 == -1) {
                return p1;
            }
            return Math.min(p1, p2 + 1);
        }
    }

    //===========================

    public static int coinsMin2(int[] arr, int index, int aim) {
        int[][] dp = new int[index + 1][aim + 1];
        for (int i = 0; i <= index; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (rest == 0) {
            dp[index][rest] = 0;
        } else if (index == arr.length) {
            dp[index][rest] = -1;
        } else {
            int p1 = process2(arr, index + 1, rest, dp);//不选index位
            int p2 = dp[index][rest] = process2(arr, index + 1, rest - arr[index], dp);//选index位}
            if (p1 == -1 && p2 == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2 + 1;
                } else if (p2 == -1) {
                    dp[index][rest] = p1;
                } else {
                    dp[index][rest] = Math.min(p1, p2 + 1);
                }
            }
        }
        return dp[index][rest];
    }

    //=================================

    public static int coinsMin3(int[] arr, int aim) {
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        for (int row = 0; row <= n; row++) {
            dp[row][0] = 0;
        }
        for (int col = 0; col <= aim; col++) {
            dp[n][col] = -1;
        }
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {

                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest - arr[index] >= 0) {
                    p2 = dp[index + 1][rest - arr[index]];
                }
                if (p1 == -1 && p2 == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[index][rest] = p1;
                    } else {
                        dp[index][rest] = Math.min(p1, p2 + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}
