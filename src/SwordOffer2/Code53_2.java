package SwordOffer2;

/**
 * 0 ～ n-1 中缺失的数字
 * <p>
 * 一个长度为 n-1 的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Code53_2 {

    public static int findMissingNumber(int[] array) {
        int n = array.length;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (array[i - 1] + 1 != array[i]) {
                index = i - 1;
            }
        }
        return array[index] + 1;
    }



    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int i = findMissingNumber(a);
        System.out.println(i);
    }
}
