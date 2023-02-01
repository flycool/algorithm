package intermediate_promote.class01;

public class Code05_MaxAllOneBorder {

    //有个N*M的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边长
    public static int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m, right, down);
        int row = m.length;
        int col = m[0].length;
        int maxBorder = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int border = 1; border <= Math.min(row - i, col - j); border++) {
                    if (right[i][j] >= border &&
                            down[i][j] >= border &&
                            down[i][j + border - 1] >= border &&
                            right[i + border - 1][j] >= border
                    ) {
                        maxBorder = Math.max(maxBorder, border);
                    }

                }
            }
        }
        return maxBorder;
    }

    //预处理数组
    //right[][] 包括 所在点右边的所有连续1的数量
    //down[][] 包括 所在点下边的所有连续1的数量
    private static void setBorderMap(int[][] m, int[][] right, int[][] down) {
        int r = m.length;
        int c = m[0].length;
        if (m[r - 1][c - 1] == 1) {
            right[r - 1][c - 1] = 1;
            down[r - 1][c - 1] = 1;
        }
        for (int i = r - 2; i != -1; i--) {
            if (m[i][c - 1] == 1) {
                right[i][c - 1] = 1;
                down[i][c - 1] = down[i + 1][c - 1] + 1;
            }
        }
        for (int i = c - 2; i != -1; i--) {
            if (m[r - 1][i] == 1) {
                right[r - 1][i] = right[r - 1][i + 1] + 1;
                down[r - 1][i] = 1;
            }
        }
        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 1, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 1}, {0, 1, 0, 1}};
        int maxSize = getMaxSize(m);
        System.out.println(maxSize);

    }

}
