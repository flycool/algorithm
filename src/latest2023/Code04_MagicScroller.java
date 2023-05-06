package latest2023;

import javafx.geometry.Point3D;

/**
 * 04 来自微众银行
 * 两个魔法卷轴问题
 * 给定一个数组arr,其中可能有正、负、0、
 * 一个魔法卷轴可以把arr中连续的一段全变成O,
 * 你希望数组整体的累加和尽可能大
 * 你有两个魔法卷轴，请返回数组尽可能大的累加和
 * 1<= arr长度 <=100000
 * -100000 <= arry里的值 <=100000
 */
public class Code04_MagicScroller {

    public int maxSum(int[] arr) {
        int n = arr.length;
        // 不用魔法卷轴
        int p1 = 0;
        for (int i : arr) {
            p1 += i;
        }
        //  使用一次魔法卷轴
        int[] left = new int[n + 1];
        int sum = arr[0];
        int maxSum = Math.max(sum, 0); //考虑全是负数的情况
        for (int i = 1; i < n; i++) {
            // 0..i 范围上，arr[i]不被魔法卷轴覆盖
            int z1 = left[i - 1] + arr[i];
            // 0..i 范围上，arr[i]被魔法卷轴覆盖
            // 为之前的最大前缀和
            int z2 = maxSum;
            left[i] = Math.max(z2, z1);
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
        }
        //只用一次魔法卷轴
        int p2 = left[n - 1];
        //用两次魔法卷轴
        // right[i]: i..n-1，使用一次魔法卷轴，最大累加和是多少
        int[] right = new int[n];
        sum = arr[n - 1];
        maxSum = Math.max(sum, 0);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i] + right[i + 1], maxSum);
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        int p3 = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            p3 = Math.max(p3, left[i - 1] + right[i]);
        }
        return Math.max(p1, Math.max(p2, p3));
    }
}




























