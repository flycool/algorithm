package jadvance.class02;

public class Code02_MaxLength2 {

    /**
     * 给定一个数组arr，无序，其中元素可正，可负，可0，再给定一个正数k。
     * 求arr所有子数组中所有元素相加和小于或等于k的最长子数组长度。
     * 缩减可能性
     */
    public static int getMaxLenth(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] minSum = new int[n];//以i出发的子数组，最小和
        int[] minSumEnd = new int[n];//以i出发的子数组，最小和时的右边界
        minSum[n - 1] = arr[n - 1];
        minSumEnd[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (minSum[i + 1] <0) {
                minSum[i] = arr[i] + minSum[i + 1];
                minSumEnd[i] = minSumEnd[i+1];
            } else {
                minSum[i] = arr[i];
                minSumEnd[i] = i;
            }
        }
        int res = 0;
        int sum = 0;
        int end = 0;
        //窗口范围为[i..end)
        for (int i = 0; i < n; i++) {
            while (end < n && sum + minSum[end] <= k) {
                sum += minSum[end];
                end = minSumEnd[end] + 1;
            }
            res = Math.max(res, end - i);
            if (end > i) {//窗口还有值
                sum -= arr[i];
            } else {
                end = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -8, 5, 9, 2};
        int maxLenth = getMaxLenth(arr, 4);
        System.out.println(maxLenth);
    }
}
