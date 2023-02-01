package SwordOffer2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 */
public class Code03 {

    public static int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                return num;
            }
        }
        return -1;
    }

    public static int findRepeatNumber3(int[] nums) {
        for (int i = 0; ; i++) {
            while (nums[i] != i) {
                int j = nums[i];
                if (nums[j] == j) {
                    return j;
                }
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 4, 5, 5};
        int result = findRepeatNumber3(nums);
        System.out.println(result);
    }

}
