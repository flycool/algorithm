package everyday;

import java.util.ArrayList;

public class Code36_largestIsland {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<Integer> sizes = new ArrayList<>();// 岛的大小
        sizes.add(0);
        sizes.add(0);
        int id = 2;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int curSize = infect(grid, i, j, id, n, m);
                    ans = Math.max(ans, curSize);
                    sizes.add(id++, curSize);
                }
            }
        }
        boolean[] visited = new boolean[id];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int up = i - 1 >= 0 ? grid[i - 1][j] : 0;
                    int down = i + 1 < n ? grid[i + 1][j] : 0;
                    int left = j - 1 >= 0 ? grid[i][j - 1] : 0;
                    int right = j + 1 < m ? grid[i][j + 1] : 0;
                    int merge = 1 + sizes.get(up);
                    visited[up] = true;
                    if (!visited[down]) {
                        merge += sizes.get(down);
                        visited[down] = true;
                    }
                    if (!visited[left]) {
                        merge += sizes.get(left);
                        visited[left] = true;
                    }
                    if (!visited[right]) {
                        merge += sizes.get(right);
                        visited[right] = true;
                    }
                    ans = Math.max(ans, merge);
                }
            }
        }
        return ans;
    }

    //感染函数
    private int infect(int[][] grid, int i, int j, int id, int n, int m) {
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] != 1) {
            return 0;
        }
        int ans = 1;
        grid[i][j] = id;
        ans += infect(grid, i - 1, j, id, n, m);
        ans += infect(grid, i + 1, j, id, n, m);
        ans += infect(grid, i, j - 1, id, n, m);
        ans += infect(grid, i, j + 1, id, n, m);
        return ans;
    }
}
