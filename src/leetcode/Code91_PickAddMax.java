package leetcode;

import java.util.Arrays;

/**
 * 91 选择拿取方式获得最大分数
 * 给定一个数组arr，当拿走某个数a的时候，其他所有的数都+a
 * 返回最终所有数都拿走的最大分数
 * （排序，从大到小拿）
 */
public class Code91_PickAddMax {

    public int pick(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans = (ans << 1) + arr[i];//观察可得 ans*2
        }
        return ans;
    }
}
