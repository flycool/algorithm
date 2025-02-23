package zuo2025.junior.class09.link;

public class C01_ListReverse {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 反转单向链表
    // https://leetcode-cn.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next; // 遍历到下一个节点
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleListNode {
        int val;
        DoubleListNode prev;
        DoubleListNode next;

        DoubleListNode(int x) {
            val = x;
        }
    }

    // 反转双向链表
    public DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.prev = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
