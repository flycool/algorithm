package everyday;

import java.util.Arrays;

/**
 * 1. 阿里
 * 牛牛今年上幼儿园了，老师叫他学习减法
 * 老师给了他5个数字，他每次操作可以选择其中的4个数字减1
 * 减1之后的数字不能小于0，因为幼儿园的牛牛还没有接触过负数
 * 现在牛牛想知道，自己最多可以进行多少次这样的操作
 * 扩展问题来自 leetcode 2141，掌握了这个题原始问题就非常简单了
 * （二分）
 */
public class Code01_fourNumberMinusOne {

    public long maxRunTime(int[] arr, int n) {
        Arrays.sort(arr);
        int size = arr.length;
        long[] sum = new long[size];
        sum[0] = arr[0];
        for (int i = 1; i < size-1; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        long l = 0, m = 0;
        long r = (int) (sum[size - 1] / n);
        long ans = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (ok(arr, sum, m, n)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    //sum : 前缀和
    public boolean ok(int[] arr, long[] sum, long time, int num) {
        int l = 0, r = arr.length - 1, m = 0;
        int mostLeft = arr.length;
        // >= time 最左
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[l] >= time) {
                mostLeft = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        num -= arr.length - mostLeft;
        long rest = mostLeft == 0 ? 0 : sum[mostLeft - 1];
        return time * (long) num <= rest;
    }
}
