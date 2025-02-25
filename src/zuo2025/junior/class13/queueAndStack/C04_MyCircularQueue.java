package zuo2025.junior.class13.queueAndStack;

public class C04_MyCircularQueue {

    // 数组实现循环双端队列
    // https://leetcode.com/problems/design-circular-queue/
    public static class MyCircularQueue {
        private final int[] queue;
        private int l, r, size;
        private final int limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int val) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    queue[0] = val;
                } else {
                    l = l == 0 ? limit - 1 : l - 1;
                    queue[l] = val;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int val) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    queue[0] = val;
                } else {
                    r = r == limit - 1 ? 0 : r + 1;
                    queue[r] = val;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == limit - 1 ? 0 : l + 1;
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? limit - 1 : r - 1;
                size--;
                return true;
            }
        }

        public int getFront() {
            return isEmpty() ? -1 : queue[l];
        }

        public int getRear() {
            return isEmpty() ? -1 : queue[r];
        }


        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
