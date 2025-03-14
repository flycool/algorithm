package zuo2025.essential.class34_link;

public class C02_ReverseNodesInGroup {

    private static class ListNode {
        public int val;
        public ListNode next;
    }

    // 2. 每k个节点一组翻转链表
    // https://leetcode.com/problems/reverse-nodes-in-k-group/
    private ListNode reverseNodesInGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKthNode(start, k);
        if (end == null) {
            return head;
        }
        // 第一组特殊，牵扯到换头的问题
        head = end;
        reverse(start, end);
        // reverse 后start变为上一组的结尾节点
        // 下面进行每组的循环
        ListNode lastTeamEnd = start;
        while (lastTeamEnd.next != null) {
            start = lastTeamEnd.next;
            end = getKthNode(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastTeamEnd.next = end;
            lastTeamEnd = start;
        }
        return head;
    }

    private ListNode getKthNode(ListNode s, int k) {
        while (--k != 0 && s != null) {
            s = s.next;
        }
        return s;
    }

    // s->a->b->c->e->下一组的开始节点
    // 调整为：e->c->b->a->s->下一组的开始节点
    public void reverse(ListNode s, ListNode e) {
        e = e.next;
        ListNode cur = s, pre = null, next = null;
        while (cur != e) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }
}
