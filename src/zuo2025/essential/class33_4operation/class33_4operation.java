package zuo2025.essential.class33_4operation;

/**
 * 加法：利用每一步无进位相加的结果 + 进位的结果不停计算，直到进位消失
 * 减法：利用加法，和一个数字x相反数就是(~x)+1
 * 乘法：常规乘法，没别的了
 * 除法：为了防止溢出，让被除数右移，而不是除数左移。从高位尝试到低位
 */
public class class33_4operation {

    public int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            // b: a和b相加时的进位信息
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public int minus(int a, int b) {
        return add(a, neg(b));
    }

    private int neg(int n) {
        return add(~n, 1); // -n
    }

    public int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            // b 最右为1时，加上a
            if (((b & 1) != 0)) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    // a, b 不能是正数最小值
    public int div(int a, int b) {
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? neg(ans) : ans;
    }

    private final int MIN = Integer.MIN_VALUE;

    // https://leetcode.com/problems/divide-two-integers/
    public int divide(int a, int b) {
        if (a == MIN && b == MIN) {
            return 1;
        }
        if (a != MIN && b != MIN) {
            return div(a, b);
        }
        if (b == MIN) {
            return 0;
        }
        if (b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        a = add(a, b > 0 ? b : neg(b));
        int ans = div(a, b);
        int offset = b > 0 ? neg(1) : 1;
        return add(ans, offset);
    }

}