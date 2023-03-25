package Involve;

/**
 * 13.
 * 给定一个整数x,如何计算x的开平方的结果
 * 输入：x是整数类型
 * 输出：开平方的结果（向下取整）
 * (二分)
 */
public class Involve_leetcode13_MySqrt {

    public int f(int x) {
        if (x == 0) {
            return x;
        }
        if (x < 3) {
            return 1;
        }
        int l = 1, r = x;
        int m = 0;
        int ans = 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
