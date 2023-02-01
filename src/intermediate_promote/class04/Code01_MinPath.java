package intermediate_promote.class04;

import javax.swing.plaf.metal.MetalIconFactory;

public class Code01_MinPath {

    /**
     * 给你一个二维数组matrix，其中每个数都是正数，要求从左上角走到右下角。
     * 每一步只能向右或向下，沿途经过的数字要累加起来。
     * 最后请返回最小的路径和
     */
    public static int minPath(int[][] matrix) {
        return process(matrix, 0, 0);
    }

    public static int process(int[][] m, int x, int y) {
        int r = m.length - 1;
        int c = m[0].length - 1;
        if (x == r && y == c) {
            return m[x][y];
        }
        int re = 0;
        if (x == r && y <= c) {
            for (int i = 0; i <= c; i++) {
                re += m[x][i];
            }
            return re;
        }
        int re2 = 0;
        if (x <= r && y == c) {
            for (int i = 0; i <= r; i++) {
                re2 += m[i][y];
            }
            return re2;
        }

        int res = m[x][y];
        int p1 = process(m, x + 1, y);
        int p2 = process(m, x, y + 1);

        res += Math.min(p1, p2);
        return res;
    }

    public static int processDp(int[][] m) {
        int r = m.length - 1;
        int c = m[0].length - 1;
        int[] dp = new int[c + 1];
        dp[c] = m[r][c];
        dp[c - 1] = m[r][c - 1] + dp[c];
        for (int i = c - 2; i >= 0; i--) {
            dp[i] = m[r][i] + dp[i + 1];
        }
        for (int i = r; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (i == r) {
                    dp[j + 1] = m[i][c] + dp[c];
                } else {
                    dp[j] = m[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {1, 4, 6, 8}, {1, 4, 6, 9}, {2, 3, 7, 8}, {1, 3, 5, 7}};
        int path = minPath(m);
        System.out.println(path);

        int i = processDp(m);
        System.out.println(i);

    }

}
