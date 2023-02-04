package SwordOffer2;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class Code21 {

    public int[] change(int[] array) {
        int j = 0; //j指向当前最后一个奇数的后一个位置
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int t = array[i];
                array[i] = array[j];
                array[j++] = t;
            }
        }
        return array;
    }

}
