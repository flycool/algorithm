package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46
 * 给你一个正整数数组nums,同时给你一个长度为m的整数数组queries
 * 第i个查询中，你需要将nums中所有元素变成queries[i]
 * 你可以执行以下操作任意次：
 * 将数组里一个元素增大或者减小1。
 * 请你返回一个长度为m的数组answer,
 * 其中answer[i]是将nums中所有元素变成queries[i]的最少操作次数。
 * 注意，每次查询后，数组变回最开始的值。
 * 测试链接：<a href="https://leetcode.cn/problems/minimum-operations-to-make-all-array-elements-equal/">leetcode</a>
 */
public class Code46_MinOpToMakeElementEqual {

    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        ArrayList<Long> ans = new ArrayList<>();
        int less, more;
        long curAns;
        for (int v : queries) {
            less = bs(nums, v);
            curAns = (long) (less + 1) * v - getSum(sum, 0, less);
            more = bs(nums, v + 1);
            curAns += getSum(sum, more + 1, n - 1) - (long) (n - more - 1) * v;
            ans.add(curAns);
        }
        return ans;
    }

    private long getSum(long[] sum, int l, int r) {
        return l > r ? 0 : (sum[r + 1] - sum[l]);
    }

    private int bs(int[] nums, int v) {
        int l = 0;
        int r = nums.length - 1;
        int m, ans = -1;
        while (l <= r) {
            m = (l + r) >> 1;
            if (nums[m] < v) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
