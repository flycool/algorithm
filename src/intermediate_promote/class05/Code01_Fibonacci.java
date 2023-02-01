package intermediate_promote.class05;

public class Code01_Fibonacci {

    //斐波那契 级别为 log(n) 的算法
    public static int fi(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        //f(n) = f(2)*res[0][0] + f(1)*res[1][0]
        return res[0][0] + res[1][0];
    }


    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatraix(res, t);
            }
            t = muliMatraix(t, t);
        }
        return res;
    }

    //两个矩阵相乘
    private static int[][] muliMatraix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fi(8));
    }

}
