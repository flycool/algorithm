package leetcode;

/**
 * 95 整体变有序的最小交换次数
 * 一个无序数组长度为n，所有数字都不一样，并且值都在[0...n-1]范围上
 * 返回让这个无序数组变成有序数组的最小交换次数
 */
public class Code95_minSwap {

    public int minSwap(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) { // 回到i位置再判断
                swap(arr, i, arr[i]);
                ans++;
            }
        }
        return ans;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
