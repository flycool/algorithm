package zuo2025.essential.class26;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class C01_MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 合并K个有序链表
    // https://leetcode.com/problems/merge-k-sorted-lists/
    public ListNode mergeKSortedLists(ArrayList<ListNode> arr) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : arr) {
            if (node != null) {
                heap.add(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }

        ListNode h = heap.poll();
        ListNode pre = h;
        if (pre.next != null) {
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return h;
    }
}
