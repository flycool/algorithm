package leetcode;

//75 leetcode 0073 矩阵置零 （像炸弹人游戏）
public class P_0073_MatrixZero {

    public int[][] zeroMatrix(int[][] matrix) {
        boolean rowZero = false;
        boolean colZero = false;
        int i = 0, j = 0;
        for (j = 0; j < matrix.length; j++) {
            if (matrix[0][j] == 0) { //第0行
                rowZero = true;
                break;
            }
        }
        for (i = 0; i < matrix[0].length; i++) {
            if (matrix[i][0] == 0) { //第0列
                colZero = true;
                break;
            }
        }

        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //更新
        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZero) {
            for (i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colZero) {
            for (i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
