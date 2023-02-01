package SwordOffer2;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;

/**
 * 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class Code04 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int j = Arrays.binarySearch(row, target);
            if (j >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 0 || column == 0) {
            return false;
        }
        for (int i = row - 1, j = 0; i <= 0 && j < column; ) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
