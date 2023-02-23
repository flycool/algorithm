package leetcode;

//71 leetcode 0036 有效的数独
//给定的数字是否是有效的数独，不需要解决
public class P_0036_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];// 每行
        boolean[][] col = new boolean[9][10];// 每列
        boolean[][] bucket = new boolean[9][10];// 每9个格子为一个桶
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bucketId = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || bucket[bucketId][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bucketId][num] = true;
                }
            }
        }
        return true;
    }
}
