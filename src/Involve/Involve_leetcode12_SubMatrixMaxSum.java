package Involve;

/**
 * 12.
 * 给定一个矩阵，返回子矩阵的最大累加和
 * (把上下两行相加，求子数组最大累加和)
 */
public class Involve_leetcode12_SubMatrixMaxSum {

    public int maxSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;// row
        int m = matrix[0].length;// column
        int max = Integer.MIN_VALUE;
        int cur;
        int[] s;
        for (int i = 0; i < n; i++) {
            s = new int[m];
            for (int j = i; j < n; j++) {
                cur = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += matrix[j][k];//0..j行 相加
                    cur += s[k];
                    max = Math.max(cur, max);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }
}
