package zuo2025.essential.class34_link;

public class C04_IsPalindrome {

    private static class ListNode {
        public int val;
        public ListNode next;
    }

    // 4. 判断链表是否是回文结构。（快慢指针找中点）
    // https://leetcode-cn.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        // 找中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 现在slow就是中点，从中点开始往后的节点逆序
        ListNode pre = slow;
        ListNode cur = pre.next;
        ListNode next = null;
        // pre->cur->next
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 上面的过程已经把链表调整成从左右两侧往中间指
        // head ->...-> slow <- .. <-pre
        boolean ans = true;
        ListNode left = head;
        ListNode right = pre;
        while (left != null && right != null) {
            if (left.val != right.val) {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // 把链表调整回原来的样子
        cur = pre.next;
        pre.next = null;
        next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;

    }

}
