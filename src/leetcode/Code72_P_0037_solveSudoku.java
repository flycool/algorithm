package leetcode;

//72 leetcod 0037 解数独
public class Code72_P_0037_solveSudoku {

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        initMap(row, col, bucket, board);
        process(board, 0, 0, row, col, bucket);
    }

    private boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        if (i == 9) {
            return true;
        }
        int nextI = j != 8 ? i : i + 1;
        int nextJ = j != 8 ? j + 1 : 0;
        if (board[i][j] == '.') {
            return process(board, nextI, nextJ, row, col, bucket);
        } else {
            int bid = 3 * (i / 3) + (j / 3);
            for (int num = 1; num <= 9; num++) {
                if (!row[i][num] && !col[j][num] && !bucket[bid][num]) {
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                    board[i][j] = (char) (num - '0');
                    if (process(board, nextI, nextJ, row, col, bucket)) {
                        return true;
                    }
                    //恢复现场
                    row[i][num] = false;
                    col[j][num] = false;
                    bucket[bid][num] = false;
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }

    private void initMap(boolean[][] row, boolean[][] col, boolean[][] bucket, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bucketId = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bucketId][num] = true;
                }
            }
        }
    }

}
