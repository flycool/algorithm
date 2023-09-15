package everyday;

/**
 * 67 来自谷歌
 * 给定一个数组arr,长度为n
 * 表示n个服务员，每个人服务一个人的时间
 * 给定一个正数m,表示有m个人等位
 * 如果你是刚来的人，请问你需要等多久？
 * 假设：m远远大于n,比如n<=1000,m<=10的9次方，该怎么做？
 *
 * @see: everyday.Code26_waitingTime
 * <p>
 * 1.小根堆模拟 [0,3],[0,7]...
 * 2.最优解，二分
 */
public class Code67_MinWaitingTime {

    public int minWaitingTime(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int best = Integer.MAX_VALUE;
        for (int i : arr) {
            best = Math.min(best, i);
        }
        int l = 0;
        int r = m * best;
        int ans = 0;
        int t;
        while (l <= r) {
            t = (l + r) / 2;
            int cover = 0;
            for (int i : arr) {
                cover += (t / i) + 1;
            }
            if (cover >= m + 1) {
                ans = t;
                r = t - 1;
            } else {
                l = t + 1;
            }
        }
        return ans;
    }
}
