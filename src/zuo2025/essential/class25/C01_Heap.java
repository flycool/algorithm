package zuo2025.essential.class25;

public class C01_Heap {

    // i位置的数，向上调整大根堆
    private void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // i位置的数，向下调整大根堆
    private void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            // 比较左右孩子
            int bestIndex = ((l + 1) < size && arr[l + 1] > arr[l]) ? (l + 1) : l;
            // 比较当前的数和最大的孩子
            bestIndex = arr[bestIndex] > arr[i] ? bestIndex : i;
            if (bestIndex == i) {
                break;
            }
            swap(arr, bestIndex, i);
            i = bestIndex;
            l = i * 2 + 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
