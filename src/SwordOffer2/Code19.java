package SwordOffer2;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Code19 {

    //双指针
    public int[] exchange(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j++] = t; // j 指向当前奇数的下一个位置
            }
        }
        return nums;
    }
}
