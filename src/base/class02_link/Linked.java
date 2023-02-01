package base.class02_link;


/**
 * 题目
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。如果不想交，返回null。
 * 要求:如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 */
public class Linked {

    class Node {
        int value;
        Node next;
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noloope(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


    //找到链表的第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; //slow
        Node n2 = head.next.next; //fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {//快指针到最后
                return null;//无环
            }
            n2 = n2.next.next;//快指针走2步
            n1 = n1.next;//慢指针走1步
        }
        n2 = head;//快指针重置到头部
        //快慢指针都移动一步，当它们相遇时，就是第一个入环点 (结论，不要问为什么)
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    //如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
    public static Node noloope(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        //遍历链表
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;

        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        // 不想交
        if (cur1 != cur2) {
            return null;
        }
        //n: 链表1的长度减去链表2的长度
        cur1 = n > 0 ? head1 : head2; //谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;//谁短，谁的头变成cur2
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个有换链表，返回第一个相交节点，不想交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2; //谁长，谁的头变成cur1
            cur2 = cur1 == head1 ? head2 : head1;//谁短，谁的头变成cur2
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }

}
