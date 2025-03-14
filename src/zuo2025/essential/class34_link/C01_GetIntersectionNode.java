package zuo2025.essential.class34_link;

public class C01_GetIntersectionNode {

    private static class ListNode {
        public int val;
        public ListNode next;
    }

    // 1. 返回两个无环链表相交的第一个节点
    // https://leetcode.com/problems/intersection-of-two-linked-lists/
    private ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return null;
        }
        ListNode a = h1; // long list
        ListNode b = h2; // short list
        int diff = 0;
        while (a.next != null) {
            a = a.next;
            diff++;
        }
        while (b.next != null) {
            b = b.next;
            diff--;
        }
        // 两链表最后的节点必相等
        if (a != b) {
            return null;
        }
        if (diff < 0) {
            a = h2;
            b = h1;
        }
        diff = Math.abs(diff);
        while (diff-- != 0) {
            a = a.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
