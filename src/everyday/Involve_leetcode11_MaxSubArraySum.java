package everyday;

import java.util.Currency;

/**
 * 11.
 * 返回一个数组arr，返回子数组的最大累加和
 */
public class Involve_leetcode11_MaxSubArraySum {

    public int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int cur = arr[0];
        for (int i = 1; i < n; i++) {
            cur += arr[i];
            ans = Math.max(ans, cur);
            cur = Math.max(cur, 0);
        }
        return ans;
    }
}
