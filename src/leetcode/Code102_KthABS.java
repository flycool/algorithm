package leetcode;

//102 找到所有数字对差值的绝对值的第k小
//二分来逼近k
public class Code102_KthABS {

    public int kthABS(int[] arr, int k) {
        int n = arr.length;
        if (n < 2 || k < 1 || k > ((n * (n - 1)) >> 1)) {
            return -1;
        }
        int l = 0, r = arr[n - 1] - arr[0];
        int mid = 0;
        int rightest = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            // 数字对差值的绝对值 <=mid 的数字对个数，是不是 <k 个的
            if (isValid(arr, mid, k)) {
                rightest = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return rightest + 1;
    }

    private boolean isValid(int[] arr, int limit, int k) {
        int x = 0;
        int n = arr.length;
        for (int l = 0, r = 1; l < n; r = Math.max(r, ++l)) {
            while (r < n && arr[r] - arr[l] <= limit) {
                r++;
            }
            x += r - l + 1;
        }
        return x < k;
    }
}
