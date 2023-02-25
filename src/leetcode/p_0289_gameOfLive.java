package leetcode;

/**
 * 84 leetcode 0289 生命游戏
 * 把0，1变成32位，用倒数第二位标记下一轮的状态
 */
public class p_0289_gameOfLive {

    public void gameOfLive(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int neighbors = neighbors(arr, i, j);
                if (neighbors == 3 || (arr[i][j] == 1 && neighbors == 2)) {
                    arr[i][j] |= 2;//用倒数第二位标记下一轮的状态
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] >>= 1;
            }
        }
    }

    //b[i][j] 位置周围有多少个1
    public int neighbors(int[][] b, int i, int j) {
        return f(b, i - 1, j - 1)
                + f(b, i - 1, j)
                + f(b, i - 1, j + 1)
                + f(b, i, j - 1)
                + f(b, i, j + 1)
                + f(b, i + 1, j - 1)
                + f(b, i + 1, j)
                + f(b, i + 1, j + 1);


    }

    public int f(int[][] arr, int i, int j) {
        int n = arr.length;
        int m = arr[0].length;
        return ((i >= 0 && i < n && j >= 0 && j < m) && (arr[i][j] == 1)) ? 1 : 0;
    }
}


