package SwordOffer2;

import SwordOffer2.datastruct.Node;

/**
 *两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Code52 {

    /**
     * 使用两个指针 cur1, cur2 分别指向两个链表 headA, headB。
     * 同时遍历链表，当 cur1 到达链表 headA 的末尾时，重新定位到链表 headB 的头节点；当 cur2 到达链表 headB 的末尾时，重新定位到链表 headA 的头节点。
     * 若两指针相遇，所指向的结点就是第一个公共节点。若没相遇，说明两链表无公共节点，此时两个指针都指向 null。
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        Node cur1 = headA, cur2 = headB;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur1;
    }
}
