package zuo2025.essential.class26;

import java.util.Arrays;

// 线段最多重合问题
// 用堆实现
public class C02_MaxCover {

    private final int maxn = 10001;

    // int[][] lines = new int[maxn][2]
    public int maxCover(int[][] lines, int n) {
        Heap heap = new Heap(maxn);
        heap.size = 0;

        Arrays.sort(lines, 0, n, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 小根堆的最小值 与 线段的起点位置比较
            while (heap.size > 0 && heap.get()[0] <= lines[i][0]) {
                heap.pop();
            }
            // 堆放入线段的终点位置
            heap.add(lines[i][1]);
            ans = Math.max(ans, heap.size);
        }
        return ans;
    }

    private static class Heap {
        private int size;
        // 小根堆
        private final int[] heap;

        Heap(int n) {
            heap = new int[n];
        }

        public void add(int x) {
            heap[size] = x;
            int i = size++;
            while (heap[i] < heap[(i - 1) / 2]) {
                swap(heap, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        public void pop() {
            swap(heap, 0, --size);
            int i = 0, l = 1;
            while (l < size) {
                int best = (l + 1 < size && heap[l + 1] < heap[l]) ? l + 1 : l;
                best = heap[best] < heap[i] ? best : i;
                if (best == i) {
                    break;
                }
                swap(heap, i, best);
                i = best;
                l = i * 2 + 1;
            }
        }

        public int[] get() {
            return heap;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
