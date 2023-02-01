package intermediate_promote.class06;

public class Code06_ConvertLink {

    //给定一个搜索二叉树的头结点head，请转化成一条有序的双向链表，并返回链表的头节点
    //二叉树递归套路
    private static class Node {
        public Node left;
        public Node right;
    }

    private static class Info {
        public Node start;
        public Node end;

        public Info(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Node getHead(Node x) {
        if (x == null) {
            return null;
        }
        return process(x).start;
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(null, null);
        }
        Info leftHead = process(x.left);
        Info rightHead = process(x.right);
        if (leftHead.end != null) {
            leftHead.end.right = x;
        }
        x.left = leftHead.end;
        x.right = rightHead.start;
        if (rightHead.start != null) {
            rightHead.start.left = x;
        }
        return new Info(leftHead.start != null ? leftHead.start : x,
                rightHead.end != null ? rightHead.end : x);

    }

}
