package base_promote;

/**
 * 一种遍历二叉树的方式，并且时间复杂度O(N)，额外空间复杂度O(1)
 * 通过利用原树中大量空闲指针的方式，达到节省空间的目的
 * <p>
 * Morris遍历细节
 * <p>
 * 假设来到当前节点cur，开始时cur来到头节点位置
 * 1.如果cur没有左孩子，cur向右移动(cur=cur.right)
 * 2.如果cur有左孩子，找到左子树最右的节点 mostRight:
 * a.如果mostRight的右指针指向空，让其指向cur，然后cur向左移动(cur = cur.left)
 * b.如果mostRight的右指针指cur，让其指向null，然后cur向右移动(cur = cur.right)
 * 3.cur为空时遍历停止
 * <p>
 * 有左子树的节点，能到达2次，没有的只能到达1次
 */
public class class08_morris {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//有左子树
                //循环完后，mostRight变成cur的最右节点
                while (mostRight != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第2次来到cur, mostRight.right == cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    //先序: 只能到达1次，直接打印，2次的，取第1次打印
    public static void morrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//有左子树
                while (mostRight != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//第一次来到cur
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第2次来到cur, mostRight.right == cur
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    //中序: 只能到达1次，直接打印，2次的，取第2次打印
    public static void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//有左子树
                while (mostRight != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第2次来到cur, mostRight.right == cur
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    //===============================================

    //后序: 第2到达节点时，逆序打印节点左树的右边界，然后单独逆序打印整棵树的右边界
    public static void morrisPost(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//有左子树
                while (mostRight != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第2次来到cur, mostRight.right == cur
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    //以x为头节点， 逆序打印整颗树的右边界
    private static void printEdge(Node x) {
        Node tail = reverseEdge(x);
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    //============================================
    //是否搜索二叉树，使用morris遍历判断，使用中morris序遍历
    public static boolean isBTS(Node head) {
        if (head == null) {
            return true;
        }
        Node cur = head;
        Node mostRight = null;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {//有左子树
                while (mostRight != null && mostRight != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {//第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                } else {//第2次来到cur, mostRight.right == cur
                    mostRight.right = null;
                }
            }
            if (cur.value <= preValue) {//判断是否所有值都是升序
                return false;
            }
            preValue = cur.value;
            cur = cur.right;
        }
        return true;
    }

}
