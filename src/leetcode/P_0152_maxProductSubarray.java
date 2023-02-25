package leetcode;

/**
 * 76 leetcode 0152 乘积最大子数组
 * 1. dp[i]
 * 2. dp[i]*dp[i-1]
 * 3. dp[i]*dp[i-1]（最小）
 * 每个位置求两答案，最大和最小（考虑负数情况）
 */
public class P_0152_maxProductSubarray {

    public double max(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        double premax = arr[0];
        double premin = arr[0];
        double ans = arr[0];
        for (int i = 1; i < n; i++) {
            double p1 = arr[i];
            double p2 = arr[i] * premax;
            double p3 = arr[i] * premin;
            double curmax = Math.max(Math.max(p1, p2), p3);
            double curmin = Math.min(Math.min(p1, p2), p3);

            ans = Math.max(ans, curmax);
            premax = curmax;
            premin = curmin;
        }
        return ans;
    }
}
