package zuo2025.essential.class34_link;

public class C03_CopyRandomList {

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            this.val = v;
        }
    }

    // 3. 复制带随机指针的链表
    // https://leetcode-cn.com/problems/copy-list-with-random-pointer/
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        // 1->2->3
        // 变成：1->1'->2->2'->3->3'->...
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy = null;
        // 利用上面新老节点的结构关系，设置每一个新节点的random指针
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node ans = head.next; // 新链表头节点
        cur = head;
        // 新老链表分离：新老链表各自重新连接在一起
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return ans;
    }


}
