package everyday;

/**
 * 66 来自字节
 * 给定一个n*m的二维矩阵，每个位置都是字符
 * U、D、L、R表示传送带的位置，会被传送到：上、下、左、右
 * . 、O分别表示空地、目标，一定只有一个目标点
 * 可以在空地上选择上、下、左、右四个方向的一个
 * 到达传送带的点会被强制移动到其指向的下一个位置
 * 如果越界直接结束，返回有几个点可以到达O点
 *
 * 宽度优先遍历
 */
public class Code66_WhereCanReachTarget {

    public int num(char[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] queue = new int[n * m][2]; // 第二维的0,1 分别表示map的坐标
        int l = 0, r = 0;
        int ans = 0;
        //find O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'O') {
                    visited[i][j] = true;
                    //把 O 点放入队列首位，然后 r++ 指向下个位置
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    break;
                }
            }
        }
        while (l < r) {
            ans++; // 对列又值代表有一个答案
            int[] cur = queue[l++];
            int row = cur[0];
            int col = cur[1];
            // 把符合条件的点 进入队列
            // 上
            if ((row - 1) >= 0 && !visited[row - 1][col] && (map[row - 1][col] == 'D' || map[row - 1][col] == '.')) {
                visited[row - 1][col] = true;
                queue[r][0] = row - 1;
                queue[r++][1] = col;
            }
            // 下
            if ((row + 1) < n && !visited[row + 1][col] && (map[row + 1][col] == 'U' || map[row + 1][col] == '.')) {
                visited[row + 1][col] = true;
                queue[r][0] = row + 1;
                queue[r++][1] = col;
            }
            // 左
            if ((col - 1) >= 0 && !visited[row][col - 1] && (map[row][col - 1] == 'U' || map[row][col - 1] == '.')) {
                visited[row][col - 1] = true;
                queue[r][0] = row;
                queue[r++][1] = col - 1;
            }
            // 右
            if ((col + 1) < n && !visited[row][col + 1] && (map[row][col + 1] == 'U' || map[row][col + 1] == '.')) {
                visited[row][col + 1] = true;
                queue[r][0] = row;
                queue[r++][1] = col + 1;
            }
        }
        return ans;
    }
}
