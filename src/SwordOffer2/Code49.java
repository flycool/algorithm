package SwordOffer2;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 丑数
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
public class Code49 {

    //优先队列 最小堆
    public int nthUglyNumber(int n) {
        HashSet<Long> vis = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        vis.add(1L);
        q.offer(1L);
        int[] f = new int[]{2, 3, 5};
        long ans = 0;
        while (n-- > 0) {
            ans = q.poll();
            for (int v : f) {
                long next = ans * v;
                if (vis.add(next)) {
                    q.offer(next);
                }
            }
        }
        return (int) ans;
    }

    //动态规划
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = dp[p2] * 2, next3 = dp[p3] * 3, next5 = dp[p5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) ++p2;
            if (dp[i] == next3) ++p3;
            if (dp[i] == next5) ++p5;
        }
        return dp[n - 1];
    }
}
