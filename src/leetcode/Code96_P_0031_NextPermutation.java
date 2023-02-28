package leetcode;

/**
 * 96 leetcode 0031 下一个排列
 * 给定一个数组，
 * 返回它全排列的下一个状态是什么（状态按字典序排列）
 */
public class Code96_P_0031_NextPermutation {

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        //从右开始遍历，找到一次降序的index
        int firstLess = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                firstLess = i;
                break;
            }
        }
        if (firstLess < 0) {//已经有序了，即字典序最大了，回到最开始的状态（最小的字典序），是循环的
            reverse(arr, 0, n - 1);
        } else {
            int firstChange = -1;
            for (int i = n - 1; i > firstLess; i--) {
                if (arr[i] > arr[firstLess]) {
                    firstChange = i;
                    break;
                }
            }
            swap(arr, firstLess, firstChange);
            reverse(arr, firstLess + 1, n - 1);
        }
    }

    //反转数组
    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
