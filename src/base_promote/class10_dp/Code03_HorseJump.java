package base_promote.class10_dp;

/**
 * 马在(0,0), 跳k步后到达 (a,b), 求有几种跳法
 */
public class Code03_HorseJump {

    public static int horseJump(int x, int y, int k) {
        return process(x, y, k);
    }

    private static int process(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        if (step == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }
        return process(x - 1, y + 2, step - 1) +
                process(x - 2, y + 1, step - 1) +
                process(x - 2, y - 1, step - 1) +
                process(x - 1, y - 2, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x + 2, y - 1, step - 1) +
                process(x + 2, y + 1, step - 1) +
                process(x + 1, y + 2, step - 1);
    }

    private static int dpWay(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || step < 0) {
            return 0;
        }
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1; //0层
        for (int i = 1; i <= step; i++) { //从1层开始
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 10; k++) {
                    dp[j][k][i] += geValue(dp, j - 1, k + 2, i - 1);
                    dp[j][k][i] += geValue(dp, j - 2, k + 1, i - 1);
                    dp[j][k][i] += geValue(dp, j - 2, k - 1, i - 1);
                    dp[j][k][i] += geValue(dp, j - 1, k - 2, i - 1);
                    dp[j][k][i] += geValue(dp, j + 1, k - 2, i - 1);
                    dp[j][k][i] += geValue(dp, j + 2, k - 1, i - 1);
                    dp[j][k][i] += geValue(dp, j + 2, k + 1, i - 1);
                    dp[j][k][i] += geValue(dp, j + 1, k + 2, i - 1);
                }
            }
        }
        return dp[x][y][step];
    }

    private static int geValue(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) {
            return 0;
        }
        return dp[row][col][step];
    }

}
