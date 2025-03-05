package zuo2025.essential.class25;

public class C01_Heap {

    /**
     * 大根堆：
     * 任何子树的最大值在顶部
     * <p>
     * i的父亲：(i-1)/2
     * i的左节点：(i*2) +1
     * i的右节点：(i*2) +2
     *
     */

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

    // 从顶到底建立大根堆 O(n*logn)
    // 依次弹出堆内最大值并排好序，O(n*logn)
    // 整体时间复杂度 O(n*logn)
    public void heapSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            heapInsert(arr, i);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    // 从底到顶建立大根堆 O(n)
    // 依次弹出堆内最大值并排好序，O(n*logn)
    // 整体时间复杂度 O(n*logn)
    public void heapSort2(int[] arr) {
        int n = arr.length;
        // 从n开始建立
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }
}
