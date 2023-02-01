package base_promote;

import java.util.LinkedList;

public class class04_SlidingWindowMaxArray {

    public static class WindowMax {
        private int L;
        private int R;
        private int[] arr;
        private LinkedList<Integer> qmax;

        public WindowMax(int[] arr) {
            L = -1;
            R = 0;
            this.arr = arr;
            this.qmax = new LinkedList<>();
        }

        public void addNumFromRight() {
            if (R == arr.length) {
                return;
            }
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            R++;
        }

        public void removeNumFromLeft() {
            if (L >= R - 1) {
                return;
            }
            L++;
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
        }

        public Integer getMax() {
            if (!qmax.isEmpty()) {
                return arr[qmax.pollFirst()];
            }
            return null;
        }
    }

    /**
     * 如果数组长度为n，窗口大小为w，则一共有n-w+1个窗口的最大值。
     * 请实现一个函数，
     * 输入：整型数组arr，窗口大小为w
     * 输出：一个长度为n-w+1的数组res。
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {//i-w为过期的下标
                qmax.pollFirst();
            }
            if (i >= w - 1) {//窗口已形成
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 4, 7, 8, 9, 2, 4};
        int[] res = getMaxWindow(arr, 4);
        for (int re : res) {
            System.out.println(re);
        }
    }
}


















