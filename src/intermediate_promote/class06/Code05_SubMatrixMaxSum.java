package intermediate_promote.class06;

import java.sql.SQLOutput;

public class Code05_SubMatrixMaxSum {

    //给定一个整型矩阵，返回子矩阵的最大累计和。
    //假设答案法
    //压缩数组
    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int r = m.length;
        int c = m[0].length;
        int[] arr = null;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            arr = new int[c];
            for (int j = i; j < r; j++) {
                cur = 0;
                for (int k = 0; k < c; k++) {
                    if (j == i) {
                        arr[k] = m[i][k];
                    } else {
                        arr[k] = m[i][k] + m[j][k];
                    }
                    cur += arr[k];
                    max = Math.max(max, cur);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] m = {{-9, 4, 7}, {6, -4, 6}, {-8, -7, 6}};
        System.out.println(maxSum(m));

    }
}
