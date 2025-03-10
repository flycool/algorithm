package zuo2025.essential.class23_quicksort;

public class C01_QuickSort {

    // 经典随机快速排序
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机选一个数，常数时间较大
        // 但只有这一下随机，才能在概率上把快速排序的时间复杂度收敛到O(N*logN)
        int x = arr[l + (int) (Math.random() * (r - l + 1))];
        partition(arr, l, r, x);
        int left = first;
        int right = last;
        quickSort(arr, l, left - 1);
        quickSort(arr, right + 1, r);
    }

    // 也是荷兰国旗问题
    private static int first;
    private static int last;
    // <x 放在左边，==x放中间，>x放右边
    private void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, first++, i++);
            } else if (arr[i] > x) {
                swap(arr, i, last--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
