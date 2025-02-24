package zuo2025.junior.class13.queueAndStack;

public class C03_MinStack {

    // https://leetcode.com/problems/min-stack/
    public static class MinStack {
        private final int[] data;
        private final int[] min;
        private int size;

        private final int n = 8001;

        MinStack() {
            data = new int[n];
            min = new int[n];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || val <= min[size - 1]) {
                min[size] = val;
            } else {
                // val > min[size - 1]，重复压入原来最小值
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }

    }
}
