package Involve;

/**
 * 7.
 * 给定一个有序数组arr,arr表示i号点在x轴上的位置，
 * 所以整个arr表示一些点在x轴上从左往右的分布，
 * 给定一个正数len,表示绳子的长度，
 * 返回绳子最多能覆盖几个点？
 * (绳子末尾盖住第i好点)
 */
public class Involve_leetcode07_Role {

    public int maxLen(int[] arr, int len) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int ans = 0;
        int left = 0, right = 0;
        while (left < n) {
            while (right < n && arr[right] - arr[left] <= left) {
                right++;
            }
            ans = Math.max(ans, right - (left++));
        }
        return ans;
    }
}
