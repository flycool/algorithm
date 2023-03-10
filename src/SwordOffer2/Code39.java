package SwordOffer2;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Code39 {

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        Arrays.sort(nums);
        return nums[half];
    }

    //摩尔投票法
    public static int majorityElement2(int[] nums) {
        int cnt = 0, m = 0;
        for (int v : nums) {
            if (cnt == 0) {
                m = v;
                cnt=1;
            } else {
                cnt += (m == v ? 1 : -1);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement2(a);
        System.out.println(i);
    }
}
