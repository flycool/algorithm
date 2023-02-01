package jadvance.class01;

public class Code01_MaxGap {
    /**
     * 给定一个数组，求如果排序之后，相邻两数的最大差值。
     * 要求时间复杂度O(N)，且要求不能用非基于比较的排序
     * 多一个空桶，一个平凡解，排除桶里的数，起到优化作用
     */
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[n + 1];
        int[] maxs = new int[n + 1];
        int[] mins = new int[n + 1];
        int bid = 0; //桶号
        for (int i = 0; i < n; i++) {
            bid = bucket(arr[i], n, min, max);
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
            hasNum[bid] = true;
        }
        int lastMax = maxs[0];
        int res = 0;
        int j = 1;
        for (; j <= n; j++) {
            if (hasNum[j]) {
                res = Math.max(res, mins[j] - lastMax);
                lastMax = maxs[j];
            }
        }
        return res;
    }

    //数字i再第几号桶
    private static int bucket(int i, int n, int min, int max) {
        return (i - min) * n / (max - min);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 19, 30, 50};
        int i = maxGap(arr);
        System.out.println(i);
    }
}
