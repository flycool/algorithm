package SwordOffer2;

import java.util.Arrays;

/**
 * 连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class Code42 {

    // nums = [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int f = 0; //表示子数组的累加和
        for (int num : nums) {
            f = Math.max(f + num, num);// or f = Math.max(f, 0) + num;
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
