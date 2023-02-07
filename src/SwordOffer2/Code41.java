package SwordOffer2;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Code41 {

    private class MedianFinder {
        private PriorityQueue<Integer> q1 = new PriorityQueue<>(); //小根堆
        private PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> b - a); //大根堆

        public void addNum(int num) {
            if (q1.size() > q2.size()) {
                q1.offer(num);
                q2.offer(q1.poll());
            } else {
                q2.offer(num);
                q1.offer(q2.poll());
            }
        }

        public double findMedian() {
            if (q1.size() > q2.size()) {
                return q1.peek();
            }
            return (q1.peek() + q2.peek()) / 2.0;
        }
    }
}
