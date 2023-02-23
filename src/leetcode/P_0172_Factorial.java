package leetcode;

/**
 * 77 leetcode 172 阶乘后的零
 * 2的因子肯定比5多
 * 也就是5的因子的个数
 * 1. 每5个数有一个5的因子 n/5
 * 2. 每25个数多出来一个5的因子 n/25
 * ...
 * n/5 + n/25 + n/125 + ...直到n为0
 */
public class P_0172_Factorial {

    public int FactorialTailingZeros(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
