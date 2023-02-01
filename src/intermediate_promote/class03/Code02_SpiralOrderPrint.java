package intermediate_promote.class03;

import java.awt.geom.CubicCurve2D;

public class Code02_SpiralOrderPrint {

    //用螺旋的方式打印矩阵
    public static void spiralOrderPrint(int[][] m) {
        int tr = 0;
        int tc = 0;
        int dr = m.length - 1;
        int dc = m[0].length - 1;
        while (tr <= dr && tc <= dc) {
            printEdge(m, tr++, tc++, dr--, dc--);
        }
    }

    private static void printEdge(int[][] m, int a, int b, int c, int d) {
        if (a == c) {//行相同
            for (int i = b; i <= d; i++) {
                System.out.print(m[a][i] + " ");
            }
        } else if (b == d) {//列相同
            for (int i = a; i <= c; i++) {
                System.out.print(m[i][b] + " ");
            }
        } else {
            //当前行列
            int curc = b;
            int curr = a;
            //右下左上打印
            while (curc != d) {
                System.out.print(m[a][curc] + " ");
                curc++;
            }
            while (curr != c) {
                System.out.print(m[curr][d] + " ");
                curr++;
            }
            while (curc != b) {
                System.out.print(m[c][curc] + " ");
                curc--;
            }
            while (curr != a) {
                System.out.print(m[curr][b] + " ");
                curr--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 4, 5}, {3, 5, 7, 9}, {12, 4, 6, 8}, {2, 4, 67, 8}};
        spiralOrderPrint(m);
    }


}
