package SwordOffer2;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Code18 {

    private class Node {
        int value;
        Node next;
        public Node(int value, Node node) {
            this.value = value;
            this.next = node;
        }

    }

    public Node deleteNode(Node head, int value) {
        Node dummy = new Node(0, head);
        for (Node cur = dummy; cur.next != null; cur = cur.next) {
            if (cur.next.value == value) {
                cur.next = cur.next.next;
                break;
            }
        }
        return dummy.next;
    }

}
