package zuo2023;

/**
 * 给定一个长度为3N的数组，其中最多含有0、1、2三种值
 * 你可以把任何一个连续区间上的数组，全变成0、1、2中的一种
 * 目的是让0、1、2三种数字的个数都是N
 * 返回最小的变化次数
 */
public class Code15_MinChageTime {

    public int minTimes(int[] arr) {
        int[] cnt = new int[3];
        for (int num : arr) {
            cnt[num]++;
        }
        if (cnt[0] == cnt[1] && cnt[0] == cnt[2]) {
            return 0;
        }
        int n = arr.length;
        int m = n / 3;
        if ((cnt[0] < m && cnt[1] < m) || (cnt[0] < m && cnt[2] < m) || (cnt[2] < m && cnt[1] < m)) {
            return 2;
        } else {
            // 只有一种数的个数小于m的
            return once(arr, cnt, m) ? 1 : 2;
        }
    }

    private boolean once(int[] arr, int[] cnt, int m) {
        int lessValue = cnt[0] < m ? 0 : (cnt[1] < m ? 1 : 2);
        int lessTime = lessValue == 0 ? cnt[0] : (lessValue == 1 ? cnt[1] : cnt[2]);
        if (cnt[0] > m && modify(arr, 0, cnt[0], lessValue, lessTime)) {
            return true;
        }
        if (cnt[1] > m && modify(arr, 1, cnt[1], lessValue, lessTime)) {
            return true;
        }
        if (cnt[2] > m && modify(arr, 2, cnt[2], lessValue, lessTime)) {
            return true;
        }
        return false;
    }

    private boolean modify(int[] arr, int more, int moreTime, int less, int lessTime) {
        int[] cnt = new int[3];//窗口外的数
        cnt[less] = lessTime;
        cnt[more] = moreTime;
        int aim = arr.length / 3;
        int l = 0, r = 0;
        while (r < arr.length || cnt[more] <= aim) {
            // cnt[more] : 窗口外多的数有几个
            if (cnt[more] > aim) {
                cnt[arr[r++]]--;
            } else if (cnt[more] < aim) {
                cnt[arr[l++]]++;
            } else {
                // 窗口之外多的数够了，
                // 看看 少的数，和另一种数，能不能平均
                if (cnt[less] + r - l < aim) {
                    cnt[arr[r++]]--;
                } else if (cnt[less] + r - l > aim) {
                    cnt[arr[l++]]++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


}
