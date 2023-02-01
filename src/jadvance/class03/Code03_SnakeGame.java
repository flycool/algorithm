package jadvance.class03;

public class Code03_SnakeGame {


    public static class Info {
        public int yes;//用一次能力
        public int no;//不用

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static int snake(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Info cur = process(matrix, i, j);
                ans = Math.max(ans, Math.max(cur.yes, cur.no));
            }
        }
        return ans;
    }

    //从最左侧出发
    public static Info process(int[][] matrix, int row, int col) {
        if (col == 0) {
            return new Info(matrix[row][col], -matrix[row][col]);
        }
        int preNo = -1;
        int preYes = -1;
        if (row > 0) {
            Info leftUp = process(matrix, row - 1, col - 1);//左上
            if (leftUp.no >= 0) {
                preNo = leftUp.no;
            }
            if (leftUp.yes > 0) {
                preYes = leftUp.yes;
            }
        }
        Info left = process(matrix, row, col - 1);//左边
        if (left.no >= 0) {
            preNo = Math.max(preNo, left.no);
        }
        if (left.yes >= 0) {
            preYes = Math.max(preYes, left.yes);
        }
        if (row < matrix.length - 1) {
            Info leftDown = process(matrix, row + 1, col - 1);//左下
            if (leftDown.no >= 0) {
                preNo = Math.max(preNo, leftDown.no);
            }
            if (leftDown.yes >= 0) {
                preYes = Math.max(preYes, leftDown.yes);
            }
        }
        int no = -1;
        int yes = -1;
        if (preNo >= 0) {
            no = preNo + matrix[row][col];
            yes = preNo + (-matrix[row][col]);//之前不用能力，现在用
        }
        if (preYes >= 0) {
            yes = Math.max(yes, preYes + matrix[row][col]);//之前用能力，现在不用
        }
        return new Info(no, yes);
    }

    //===============================
    public static int snakeDp(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        Info[][] dp = new Info[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Info cur = processDp(matrix, i, j, dp);
                ans = Math.max(ans, Math.max(cur.yes, cur.no));
            }
        }
        return ans;
    }

    public static Info processDp(int[][] matrix, int row, int col, Info[][] dp) {
        if (dp[row][col] != null) {//缓存
            return dp[row][col];
        }
        if (col == 0) {
            dp[row][col] = new Info(matrix[row][col], -matrix[row][col]);
            return dp[row][col];
        }
        int preNo = -1;
        int preYes = -1;
        if (row > 0) {
            Info leftUp = processDp(matrix, row - 1, col - 1, dp);//左上
            if (leftUp.no >= 0) {
                preNo = leftUp.no;
            }
            if (leftUp.yes > 0) {
                preYes = leftUp.yes;
            }
        }
        Info left = processDp(matrix, row, col - 1, dp);//左边
        if (left.no >= 0) {
            preNo = Math.max(preNo, left.no);
        }
        if (left.yes >= 0) {
            preYes = Math.max(preYes, left.yes);
        }
        if (row < matrix.length - 1) {
            Info leftDown = processDp(matrix, row + 1, col - 1, dp);//左下
            if (leftDown.no >= 0) {
                preNo = Math.max(preNo, leftDown.no);
            }
            if (leftDown.yes >= 0) {
                preYes = Math.max(preYes, leftDown.yes);
            }
        }
        int no = -1;
        int yes = -1;
        if (preNo >= 0) {
            no = preNo + matrix[row][col];
            yes = preNo + (-matrix[row][col]);//之前不用能力，现在用
        }
        if (preYes >= 0) {
            yes = Math.max(yes, preYes + matrix[row][col]);//之前用能力，现在不用
        }
        dp[row][col] = new Info(no, yes);
        return dp[row][col];
    }
}
