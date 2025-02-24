package zuo2025.junior.class13.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C02_ConvertQueueAndStack {

    // stack 实现队列
    // https://leetcode.com/problems/implement-queue-using-stacks/
    public static class MyQueue {
        private final Stack<Integer> in;
        private final Stack<Integer> out;

        MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        // 1. out空了，才能把in的东西倒进out
        // 2. in要倒进out的时候，必须一次性倒完
        private void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public void push(int value) {
            in.push(value);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() & out.isEmpty();
        }
    }

    // queue 实现栈
    // https://leetcode.com/problems/implement-stack-using-queues/
    public static class MyStack {
        private final Queue<Integer> queue;

        MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int value) {
            int n = queue.size();
            queue.offer(value);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
