package everyday;

/**
 * 48 来自Facebook、亚马逊、谷歌
 * 给你一个严格升序排列的正整数数组arr和一个整数k。
 * 请你找到这个数组里第k个缺失的正整数。
 * 测试链接：https://Leetcode.cn/problems/kth-missing-positive-number/
 */
public class Code48_KthMissingNumber {

    public int findKthPositiveNumber(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        int m = 0;
        int find = arr.length; // index
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] - (m + 1) >= k) {
                find = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int preValue = find == 0 ? 0 : arr[find - 1];
        int done = preValue - find;
        return preValue + (k - done);
    }
}
