package jadvance.class02;

public class Code01_MaxLength {
    /**
     * 给定一个数组arr，无序，每个值为正数，再给定一个正数k。
     * 求arr的所有子数组中所有元素相加和为k的最长子数组长度。
     * 要求：时间复杂度O(N), 额外空间复杂度O(1)
     * 构建单调性
     */
    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int l = 0, r = 0;
        int maxLen = 0;
        int sum = arr[l];
        while (r < arr.length) {
            if (sum < k) {
                sum += arr[r++];
            } else if (sum > k) {
                sum -= arr[l++];
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
                sum -= arr[l++];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 9, 6, 6, 6, 4, 6};
        int i = maxLength(arr, 18);
        System.out.println(i);
    }
}
