package zuo2025.junior.class13.queueAndStack;

public class C01_CircularQueue {

    private int[] queue;
    private int l, r, size, limit;

    public C01_CircularQueue(int k) {
        queue = new int[k];
        l = r = size = 0;
        limit = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[r] = value;
            r = (r + 1) % limit;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            l = (l + 1) % limit;
            size--;
            return true;
        }
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[l];
        }
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        } else {
            int last = (r == 0) ? (limit - 1) : (r - 1);
            return queue[last];
        }
    }

    public boolean isFull() {
        return size == limit;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
