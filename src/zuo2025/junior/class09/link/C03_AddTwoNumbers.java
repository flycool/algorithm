package zuo2025.junior.class09.link;

public class C03_AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 两个链表相加
    // https://leetcode-cn.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int mod = sum % 10;
            if (head.val == -1) {
                // 更新头节点的值
                head.val = mod;
            } else {
                cur.next = new ListNode(mod);
                cur = cur.next;
            }
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
