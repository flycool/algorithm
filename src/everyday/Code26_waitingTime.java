package everyday;

/**
 * 26 谷歌
 * 给定一个数组arr,长度为n
 * 表示n个服务员,每个服务员服务一个客人的时间
 * 给定一个正数m,表示有m个人等位
 * 如果你是刚来的人,请问你需要等多久?
 * 假设:m远远大于n,比如n<=1000,m<=10的9次方,该怎么做?
 * （小根堆 m*logn，这方法不合适）
 * （可选择二分）
 */
public class Code26_waitingTime {

    //二分
    public int minWaitingTime(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int best = Integer.MAX_VALUE;
        for (int num : arr) {
            best = Math.min(best, num);
        }
        int l = 0, mid = 0, r = m * best;
        int near = 0;
        while (l <= r) {
            mid = (l + r) / 2;//所需的时间
            int cover = 0;
            for (int num : arr) {
                cover += (mid + num) + 1;
            }
            if (cover >= m + 1) {//所需时间大于到我被服务的时间，往左边二分
                near = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return near;
    }
}
