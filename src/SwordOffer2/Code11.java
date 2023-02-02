package SwordOffer2;

/**
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Code11 {

    public static int findMinNumsInArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return array[i];
            }
        }
        return -1;
    }

    public static int findMinNumsInArray2(int[] array) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (array[m] > array[r]) {
                l = m + 1;
            } else if (array[m] < array[r]) {
                r = m;
            } else {
                --r;
            }
        }
        return array[l];
    }


    public static void main(String[] args) {
        int[] a = {2, 2, 2, 0, 1};
        int i = findMinNumsInArray2(a);
        System.out.println(i);
    }
}
