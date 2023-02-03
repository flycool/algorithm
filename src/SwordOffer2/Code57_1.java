package SwordOffer2;

/**
 * 和为 s 的两个数字
 *
 *输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Code57_1 {

    //双指针
    public int[] twoSum(int[] array, int target) {
        int l = 0, r = array.length - 1;
        int[] ans = new int[2];
        while (l < r) {
            int s = array[l] + array[r];
            if (s == target) {
                return new int[]{array[l], array[r]};
            }
            if (s > target) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
