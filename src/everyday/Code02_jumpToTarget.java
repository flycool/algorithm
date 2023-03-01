package everyday;

/**
 * 2. 字节
 * 一开始在0位置，每一次都可以向左或者向右跳
 * 第i次能向左或者向右跳严格的i步
 * 请问从0到x位置，至少跳几次可以到达
 * leetcode : https://leetcode.com/problems/reach-a-number/
 */
public class Code02_jumpToTarget {

    public int reachNumber(long target) {
        if (target == 0) {
            return 0;
        }
        target = Math.abs(target);
        long l = 0, r = target, m = 0;
        long near = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (sum(m) >= target) {
                near = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (sum(near) == target) {
            return (int) near;
        }
        //只需两次跳跃
        if (((sum(near) - target) & 1) == 1) {
            near++;
        }
        if (((sum(near) - target) & 1) == 1) {
            near++;
        }
        return (int) near;
    }

    //结果为：奇 奇 偶 偶 奇 奇 偶 偶...
    private long sum(long n) {
        return (n * (n + 1)) / 2;
    }
}
