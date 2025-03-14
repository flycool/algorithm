package zuo2025.essential.class34_link;

public class C06_LinkSort {
    private static class ListNode {
        public int val;
        public ListNode next;
    }

    // 6. 在链表上排序。（要求时间复杂度O(n*logn))，额外空间复杂度O(1)，还要求排序有稳定性）
    // https://leetcode.com/problems/sort-list/
    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // l1...r1 每组的左部分
        // l2...r2 每组的右部分
        // next 下一组的开头
        // lastTeamEnd 上一组的结尾
        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int step = 1; step < n; step <<= 1) {
            // 第一组很特殊，因为要决定整个链表的头，单独处理
            l1 = head;
            r1 = findEnd(l1, step);
            l2 = r1.next;
            r2 = findEnd(l2, step);
            next = r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);
            head = start;
            lastTeamEnd = end;
            while (next != null) {
                l1 = next;
                r1 = findEnd(l1, step);
                l2 = r1.next;
                if (l2 == null) {
                    lastTeamEnd.next = l1;
                    break;
                }
                r2 = findEnd(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }
        }
        return head;
    }

    private static ListNode start;
    private static ListNode end;

    // l1...r1 -> null : 有序的左部分
    // l2...r2 -> null : 有序的右部分
    // 整体merge在一起，保证有序
    // 并且把全局变量start设置为整体的头，end设置为整体的尾
    private void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
        ListNode pre;
        if (l1.val <= l2.val) {
            start = l1;
            pre = l1;
            l1 = l1.next;
        } else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
            end = r1;
        } else {
            pre.next = l2;
            end = r2;
        }
    }

    private ListNode findEnd(ListNode node, int step) {
        ListNode cur = node;
        while (--step != 0 && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
