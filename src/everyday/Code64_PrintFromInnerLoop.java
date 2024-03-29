package everyday;

/**
 * 64 来自华为
 * 保证一定是n*n的正方形，实现从里到外转圈打印的功能
 * 如果n是奇数，中心点唯一，比如
 * a b c
 * d e f
 * g h i
 * e是中心点，依次打印：efihgdabc
 * 如果n是偶数，中心点为最里层2*2的右下点
 * 比如
 * a b c d e f
 * g h i j k l
 * m n o p q r
 * s t u v w x
 * y z 0 1 2 3
 * 4 5 6 7 8 9
 * 最里层是
 * o p
 * u v
 * v是中心点，依次打印：vuopqw··
 */
public class Code64_PrintFromInnerLoop {

    public void print(char[][] m) {
        int n = m.length;
        //[a,b]坐上角点，[c,d]右下角点
        // 然后一圈圈的print
        for (int a = (n - 1) / 2, b = (n - 1) / 2, c = n / 2, d = n / 2;
             a >= 0;
             a--, b--, c++, d++) {
            loop(m, a, b, c, d);
        }
    }

    private void loop(char[][] m, int a, int b, int c, int d) {
        if (a == c) {
            System.out.print(m[a][b] + " ");
        } else {
            for (int row = a+1; row <= c; row++) {
                System.out.print(m[row][d] + " ");
            }
            for (int col = d+1; col >= b; col--) {
                System.out.print(m[c][col] + " ");
            }
            for (int row = c-1; row >= a; row--) {
                System.out.print(m[row][b] + " ");
            }
            for (int col = b+1; col <= d; col++) {
                System.out.print(m[a][col] + " ");
            }
        }
    }
}
