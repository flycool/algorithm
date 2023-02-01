package intermediate_promote.class03;

public class Code03_RotateMatrix {

    //给定一个正方形矩阵，只用有限几个变量，实现矩阵中每个位置的数顺时针转动90度。
    public static void rotateMatrix(int[][] m) {
        int rlen = m.length - 1;
        int clen = m[0].length - 1;
        int tr = 0, tc = 0;
        while (tr < rlen) {
            rotatePoint(m, tr++, tc++, rlen--, clen--);
        }
    }

    private static void rotatePoint(int[][] m, int a, int b, int c, int d) {
        int temp = 0;
        //依次以4个点交换
        for (int i = 0; i < d - b; i++) {
            temp = m[a][b + i];
            m[a][b + i] = m[c - i][b];
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[a + i][d];
            m[a + i][d] = temp;
        }
    }

    public static void printRotateMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 4, 5}, {3, 5, 7, 9}, {12, 4, 6, 8}, {2, 4, 67, 8}};
        rotateMatrix(m);
        printRotateMatrix(m);
    }
}
