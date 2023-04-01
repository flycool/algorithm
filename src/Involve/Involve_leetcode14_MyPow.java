package Involve;

/**
 * 14.
 * 如何快速计算一个数x的n次方，
 * 输入：x是小数类型、n是整数类型
 * 输出：结果代表x的n次方
 * (把n二进制化)
 */
public class Involve_leetcode14_MyPow {

    public static double f(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        int pow = Math.abs(n);
        double ans = 1;
        double t = x;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                ans *= t;
            }
            pow >>= 1;
            t *= t;
        }
        return n < 0 ? (1 / ans) : ans;
    }

    public static void main(String[] args) {
        double f = f(2.0, 3);
        System.out.println(f);
    }
}
