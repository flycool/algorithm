package zuo2025.junior.class06;

// 峰值问题
// https://leetcode.com/problems/find-peak-element/
public class C03_FindPeakElement {

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        if (arr[0] > arr[1]) return 0;

        if (arr[n - 1] > arr[n - 2]) return n - 1;

        int l = 1, r = n - 2, m = 0, ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m + 1] > arr[m]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }
}
