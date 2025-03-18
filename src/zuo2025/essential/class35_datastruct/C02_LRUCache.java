package zuo2025.essential.class35_datastruct;

import java.util.HashMap;

public class C02_LRUCache {

    // 2. 实现LRU结构 (双向链表和hash表实现)
    // https://leetcode.com/problems/lru-cache/
    static class LRUCache {

        private static class DoubleNode {
            private int key;
            private int val;
            private DoubleNode last;
            private DoubleNode next;

            public DoubleNode(int k, int v) {
                key = k;
                val = v;
            }
        }

        private static class DoubleList {
            private DoubleNode head = null;
            private DoubleNode tail = null;

            public void addNode(DoubleNode newNode) {
                if (newNode == null) {
                    return;
                }
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.last = tail;
                    tail = newNode;
                }
            }

            public void moveNodeToTail(DoubleNode node) {
                if (tail == node) return;

                if (head == node) {
                    head = node.next;
                    head.last = null;
                } else {
                    node.last.next = node.next;
                    node.next.last = node.last;
                }
                node.last = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }

            public DoubleNode removeHead() {
                if (head == null) return null;

                DoubleNode ans = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = ans.next;
                    ans.next = null;
                    head.last = null;
                }
                return ans;
            }
        }

        private HashMap<Integer, DoubleNode> keyNodeMap;
        private DoubleList nodeList;
        private final int capacity;

        public LRUCache(int cap) {
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
            capacity = cap;
        }

        public int get(int key) {
            if (keyNodeMap.containsKey(key)) {
                DoubleNode ans = keyNodeMap.get(key);
                nodeList.moveNodeToTail(ans);
                return ans.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (keyNodeMap.containsKey(key)) {
                DoubleNode node = keyNodeMap.get(key);
                node.val = value;
                nodeList.moveNodeToTail(node);
            } else {
                if (keyNodeMap.size() == capacity) {
                    keyNodeMap.remove(nodeList.removeHead().key);
                }
                DoubleNode newNode = new DoubleNode(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);
            }
        }
    }
}












