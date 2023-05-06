package latest2023;

/**
 * 05 来自Facebook、亚马逊、谷歌
 * 给你一个严格升序排列的正整数数组arr和一个整数k。
 * 请你找到这个数组里第k个缺失的正整数。
 * 测试链接：https://leetcode.cn/problems/kth-missing-positive-number/
 */
public class Code05_KthMissingNumber {

    public int findKNum(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        int mid;
        int find = arr.length;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] - (mid + 1) >= k) {
                find = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int preValue = find == 0 ? 0 : arr[find - 1];
        int under = preValue - find;
        return preValue + (k - under);
    }
}
