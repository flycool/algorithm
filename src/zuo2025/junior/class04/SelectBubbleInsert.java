package zuo2025.junior.class04;

import java.util.concurrent.ForkJoinPool;

public class SelectBubbleInsert {

    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
//        array[i] = array[i] ^ array[j];
//        array[j] = array[i] ^ array[j];
//        array[i] = array[i] ^ array[j];

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // 0 ~ N-1 选择最小的放在0位置
    // 1 ~ N-1 选择最小的放在1位置
    // 2 ~ N-1 选择最小的放在2位置
    // ...
    public void selectSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int minIndex, i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
    }

    // 0 ~ n-1 之间
    // 0和1比较，1和2比较，2和3比较，...，n-2和n-1比较 （相邻的两个数），最大的放在n-1位置
    // 0 ~ n-2 之间, 重复上述过程
    public void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    // 0 ~ 0 有序
    // 0 ~ 1 比较相邻的两数是否有序
    // 新来的数和前面的数比较，如果小就交换，直到不小为止
    // 直到 0 ~ N-1 都有序
    public void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
