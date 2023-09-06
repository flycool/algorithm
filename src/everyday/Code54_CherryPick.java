package everyday;

/**
 * 54
 * 给你一个 n x n 的网格 grid ，代表一块樱桃地，每个格子由以下三种数字的一种来表示：
 *
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 请你统计并返回：在遵守下列规则的情况下，能摘到的最多樱桃数：
 *
 * 从位置 (0, 0) 出发，最后到达 (n - 1, n - 1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为 0 或者 1 的格子）；
 * 当到达 (n - 1, n - 1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为 0 ）；
 * 如果在 (0, 0) 和 (n - 1, n - 1) 之间不存在一条可经过的路径，则无法摘到任何一个樱桃。
 *
 * <a href="https://leetcode.cn/problems/cherry-pickup">leetcode</a>
 */
public class Code54_CherryPick {

    public int cherryPick(int[][] grid) {
        return getMaxCherry(grid, 0, 0, 0, 0);
    }

    private int getMaxCherry(int[][] grid, int a, int b, int c, int d) {
        int n = grid.length;
        int m = grid[0].length;
        if (a == n-1 && b == m-1) {
            if (grid[n-1][m-1] == -1 ) {
                return -1;
            }
            if (grid[n-1][m-1] == 0) {
                return 0;
            }
            return 1;
        }

        if (grid[a][b] == -1 || grid[c][d] == -1) {
            return -1;
        }

        int cur = 0;
        if (a == c && b == d) {
            if (grid[a][b] == 1) {
                cur = 1;
            }
        } else {
            int aPick = grid[a][b] == 1 ? 1 : 0;
            int bPick = grid[c][d] == 1 ? 1 : 0;
            cur = aPick + bPick;
        }

        int p1 = -1;
        if ((a + 1) < n && (c + 1) < n) {
            p1 = getMaxCherry(grid, a + 1, b, c + 1, d);
        }
        int p2 = -1;
        if ((b + 1) < n && (c + 1) < n) {
            p2 = getMaxCherry(grid, a, b + 1, c + 1, d);
        }
        int p3 = -1;
        if ((a + 1) < n && (d + 1) < n) {
            p3 = getMaxCherry(grid, a + 1, b, c, d + 1);
        }
        int p4 = -1;
        if ((b + 1) < n && (d + 1) < n) {
            p4 = getMaxCherry(grid, a, b + 1, c, d + 1);
        }

        int next = Math.max(Math.max(p1, p2), Math.max(p3, p4));

        return cur + next;
    }

    //优化，dp 可用三维，前三个坐标可推出第4个坐标

}
