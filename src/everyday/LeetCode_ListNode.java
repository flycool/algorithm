package everyday;

import java.util.HashSet;

public class LeetCode_ListNode {



    //面试题 02.07. 链表相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }


    //面试题 02.06. 回文链表
    public boolean isPalindrome(ListNode head) {
        return false;
    }

    //面试题 02.03. 删除中间节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //面试题 02.02. 返回倒数第 k 个节点
    public int kthToLast(ListNode head, int k) {
        ListNode pre = head, cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre.val;
    }

    //面试题 02.01. 移除重复节点
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode preNode = head;
        while (preNode.next != null) {
            ListNode cur = preNode.next;
            if (set.add(cur.val)) {
                preNode = preNode.next;
            } else {
                preNode.next = cur.next;
            }
        }
        preNode.next = null;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
