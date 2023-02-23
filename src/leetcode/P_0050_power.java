package leetcode;

//73 leetcode 0050 pow(x,n)
//x的n次方，n可能是负数
//把n变成二进制数，把1的位置乘如答案
public class P_0050_power {

    public double power(int x, int n) {
        if (n == 0) {
            return 1d;
        }
        int power = Math.abs(n == Integer.MIN_VALUE ? n + 1 : n);//如果是系统最小，就变成系统最大，即 n+1
        double ans = 1d;
        int t = x;
        while (power != 0) {
            if ((power & 1) == 1) {
                ans *= t;
            }
            t *= t;
            power >>= 1;
        }
        if (n == Integer.MIN_VALUE) {
            ans *= x;
        }
        return ans < 0 ? (1d / ans) : ans;
    }
}
