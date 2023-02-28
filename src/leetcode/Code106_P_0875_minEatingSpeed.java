package leetcode;

/**
 * 106 leetcode 0875 爱吃香蕉的珂珂
 * 有n堆香蕉，第i堆中有piles[i] 根香蕉，警卫将在h小时后回来
 * 珂珂吃香蕉的速度为K（根/小时）
 * 她会选择一堆香蕉，从中吃掉k根，如果这堆香蕉小于k，她将吃掉这堆
 * 所有香蕉，
 * 返回她可以在h小时内吃掉所有香蕉的最小速度
 * （二分）
 */
public class Code106_P_0875_minEatingSpeed {

    public int minEatingSpeed(int[] piles, int k) {
        int l = 0, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int m = 0;
        int ans = 0;
        while (l < r) {
            m = l + ((r - 1) >> 1);
            if (hours(piles, m) <= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int hours(int[] piles, int speed) {
        int ans = 0;
        int offset = speed - 1;//向上取整
        for (int pile : piles) {
            ans += (pile + offset) / speed;
        }
        return ans;
    }

}
