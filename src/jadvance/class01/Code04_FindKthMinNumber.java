package jadvance.class01;

public class Code04_FindKthMinNumber {

    //给定两个一维int数组A和B
    //其中：A是长度为m，元素从小到大排列。B长度为n，元素从小到大排列。
    //希望从A和B数组中，找出最大的k个数，要求：使用尽量少的比较次数。
    public static int findKthMinNumber(int[] arr1, int[] arr2, int kth) {
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Your arr is invalid!");
        }
        if (kth < 1 || kth > arr1.length + arr2.length) {
            throw new RuntimeException("K is invalid!");
        }
        int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
        int l = longs.length;
        int s = shorts.length;
        if (kth <= s) {
            return getUpMedian(shorts, 0, kth - 1, longs, 0, kth - 1);
        }
        if (kth > l) {
            if (shorts[kth - l - 1] >= longs[l - 1]) {
                return shorts[kth - l - 1];
            }
            if (longs[kth - s - 1] >= shorts[s - 1]) {
                return longs[kth - s - 1];
            }
            return getUpMedian(shorts, kth - 1, s - 1, longs, kth - s, l - 1);
        }
        //第2种情况
        if (longs[kth - s - 1] >= shorts[s - 1]) {
            return longs[kth - s - 1];
        }
        return getUpMedian(shorts, 0, s - 1, longs, kth - s, kth - 1);
    }

    /**
     * 求上中位数的原型：
     * 数组等长时，
     * 偶数二分有两个中点，前一个就叫上中位数，后一个叫下中位数
     * 分数组长度为偶数和基数
     * 取各自的上中位数，递归获取上中位数，就是整体的上中位数
     */
    //a1[s1..e1]    a2[s2..e2] 数组一定等长
    public static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1) {
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 + offset;
                e2 = mid2;
            } else {
                return a1[mid1];
            }
        }
        return Math.min(a1[s1], a2[s2]);
    }
}
