package zuo2025.junior.class09.link;

public class C02_MergeTwoList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 合并两个有序链表
    public ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        // 其中一个链表已经遍历完了，直接把另一个链表接到pre后面
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
