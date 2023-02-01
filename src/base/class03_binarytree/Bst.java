package base.class03_binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Bst {

    private static int preValue = Integer.MIN_VALUE;

    public static boolean isBTS(Node head) {
        if (head == null) return true;
        boolean isLeftBTS = isBTS(head.left);
        if (!isLeftBTS) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }
        return isBTS(head.right);
    }

    //判断是否是完全二叉树
    public static boolean isCBT(Node head) {
        if (head == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        Node l = null, r = null;
        while (!queue.isEmpty()) {
            l = head.left;
            r = head.right;

            if ((l == null && r != null) ||
                    //如果遇到了第一个左右孩子不双全的节点，又发现当前节点有孩子，返回false
                    (leaf && (l != null || r != null))
            ) {
                return false;
            }

            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    //判断是否是平衡二叉树
    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced &&
                Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced, height);
    }

    public static class ReturnType {
        private boolean isBalanced;
        private int height;

        public ReturnType(boolean ib, int h) {
            this.isBalanced = ib;
            this.height = h;
        }
    }

    //判断是否是满二叉树
    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }
        Info f = f(head);
        return f.nodes == (1 << f.height - 1);
    }

    public static Info f(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height, nodes);
    }

    public static class Info {
        private int height;
        private int nodes;

        public Info(int h, int n) {
            this.height = h;
            this.nodes = n;
        }
    }

}
