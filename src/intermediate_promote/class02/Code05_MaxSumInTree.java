package intermediate_promote.class02;

public class Code05_MaxSumInTree {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPath(Node head) {
        process(head, 0);
        return maxSum;
    }

    //二叉树每个节点都有一个int型权值，给定一课二叉树，求从根节点到叶节点的所有路径中，
    //权值和最大的值为多少
    public static void process(Node x, int preValue) {
        if (x.left == null && x.right == null) {
            maxSum = Math.max(maxSum, preValue + x.value);
            return;
        }
        if (x.left != null) {
            process(x.left, preValue + x.value);
        }
        if (x.right != null) {
            process(x.right, preValue + x.value);
        }
    }

    public static int process2(Node x) {
        if (x.left == null && x.right == null) {
            return x.value;
        }
        int next = Integer.MIN_VALUE;
        if (x.left != null) {
            next = process2(x.left);
        }
        if (x.right != null) {
            next = Math.max(next, process2(x.left));
        }
        return next + x.value;
    }


}
