package interview2022;

import java.util.PriorityQueue;

/**
 * （单元最短路径）
 * 给定一个二维数组，其中全是非负数
 * 每一步都可以从上，下，左，右四个方向运动
 * 走过的路径，会累加数字
 * 返回从左上角到右下角的最短距离
 */
public class Code12_MinDistance {

    public int bestWalk(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        //{dis, row, column}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.add(new int[]{map[0][0], 0, 0});
        boolean[][] poped = new boolean[n][m];
        int ans = 0;

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int dis = cur[0], row = cur[1], column = cur[2];
            if (poped[row][column]) {
                continue;
            }
            poped[row][column] = true;
            if (row == n - 1 && column == m - 1) {
                ans = dis;
                break;
            }
            add(dis, row - 1, column, n, m, map, poped, heap);
            add(dis, row + 1, column, n, m, map, poped, heap);
            add(dis, row, column - 1, n, m, map, poped, heap);
            add(dis, row, column + 1, n, m, map, poped, heap);
        }
        return ans;
    }

    private void add(int dis, int row, int column, int n, int m, int[][] map, boolean[][] poped, PriorityQueue<int[]> heap) {
        if (row >= 0 && row < n && column >= 0 && column < m && !poped[row][column]) {
            heap.add(new int[]{dis + map[row][column], row, column});
        }
    }

}
