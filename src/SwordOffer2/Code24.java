package SwordOffer2;

/**
 * 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Code24 {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, SwordOffer2.Code24.Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //头插法
    public Node reverseLink(Node head) {
        Node dummy = new Node(0);
        Node cur = head;
        while (cur != null) {
            cur.next = dummy.next; // cur的next 指向 dummy的next
            dummy.next = cur; //然后把cur 放到 dummy的next，就能连起来了
            cur = cur.next;
        }
        return dummy.next;
    }


}
