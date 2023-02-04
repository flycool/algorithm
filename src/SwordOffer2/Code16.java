package SwordOffer2;

/**
 * 数值的整数次方
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 快速幂算法的核心思想是将幂指数  拆分为若干个二进制位上的 1 的和，然后将 x 的 n 次幂转化为 x 的若干个幂的乘积。
 *
 */
public class Code16 {

    public static double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? qmi2(x, N) : 1.0 / qmi2(x, -N);
    }

    private static double qmi2(double a, long k) {
        double res = 1;
        while (k != 0) {
            if ((k & 1) != 0) {
                res *= a;
            }
            a *= a;
            k >>= 1;
        }
        return res;
    }

    public static double qmi(double a, long k) {
        double res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
        }
        return res;
    }



    public static void main(String[] args) {
        double qmi = qmi(2, 6);
        System.out.println(qmi);
    }
}
