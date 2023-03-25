package Involve;

/**
 * 17. 字节
 * 给定两个数a和b
 * 第1轮，把1选择给a或者b
 * 第2轮，把2选择给a或者b
 * ...
 * 第i轮，把i选择给a或者b
 * 想让a和b的值一样大，请问至少需要多少轮？
 * (sum-diff 必须为>=0 的偶数)
 */
public class Involve17_FillGapMinStep {

    public int minStep1(int a, int b) {
        if (a == b) {
            return 0;
        }
        int diff = Math.abs(a - b);
        int num = 1;
        int sum = 0;
        for (; !(sum >= diff && (sum - diff) % 2 == 0); num++) {
            sum += num;
        }
        return num - 1;
    }

    public int minStep2(int a, int b) {
        if (a == b) {
            return 0;
        }
        int diff = Math.abs(a - b);
        // 找到sum>=s,最小的i
        int begin = best(diff << 1);
        for (; (begin * (begin + 1) / 2 - diff) % 2 != 0; ) {//sum-diff 必须为>=0 的偶数
            ++begin;
        }
        return begin;
    }

    private int best(int s) {
        int l = 0,r = 1;
        while (r * (r + 1) < s) {
            l=r;
            r *= 2;
        }
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m * (m + 1) / 2 < s) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
