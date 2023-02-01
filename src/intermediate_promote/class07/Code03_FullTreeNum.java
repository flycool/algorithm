package intermediate_promote.class07;

public class Code03_FullTreeNum {

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //求完全二叉树节点的个数
    public static int getMaxNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    //O(h^2)--> O((logn)^2)
    private static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {//node的左树的高度等于h时，左树为完全二叉树
            // 左树为 2^(h-level)-1+1 ， 再递归右树
            return (1 << (h - level) + bs(node.right, level + 1, h));
        } else {
            //node的左树的高度不等于h时，右树为完全二叉树
            //右树为 2^(h-level-1)-1+1 ， 再递归左树
            return (1 << (h - level - 1) + bs(node.left, level + 1, h));
        }
    }

    // node 在 level层
    // 求node为头的子树，最大深度是多少
    // node为头的子树，是完全二叉树
    private static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}
