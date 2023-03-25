package Involve;

/**
 * 2. 小红书
 * 一个无序数组长度为n，所有数字都不一样
 * 并且值都在[0...n-1]范围上
 * 返回让这个无序数组变成有序数组的最少交换次数
 */
public class Involve02_minSwap {

    public int minSwap(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (i != arr[i]) {
                swap(arr, i, arr[i]);
                ans++;
            }
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
