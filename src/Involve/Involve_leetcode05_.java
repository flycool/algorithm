package Involve;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 5.
 * 给定一组线段，每条线段都在轴上，有开始位置和结束位置，
 * 开始位置和结束位置的数值都是整数并且结束>开始
 * 那么这组线段中，
 * 覆盖线段数量最多的区域，覆盖了多少条线段请返回。
 * (公共区域，以每段线段的开头位置作为开头计算)
 */
public class Involve_leetcode05_ {

    public int maxRange(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        int n = matrix.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek() <= matrix[i][0]) {
                heap.poll();
            }
            heap.add(matrix[i][1]);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }
}
