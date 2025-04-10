package zuo2025.essential.class36_tree;

public class C09_CountCompleteTreeNumber {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 9. 求完全二叉树的节点个数，要求时间复杂度低于O(n)
    // https:// leetcode.com/problems/count-complete-tree-nodes/
    // O(h^2) h=logn (已2为底)
    public int countNodes(TreeNode head) {
        if (head == null) return 0;
        return f(head, 1, mostLeft(head, 1));
    }

    // h: 整颗树的高度
    // return: cur这棵子树上，有多少节点
    private int f(TreeNode cur, int level, int h) {
        // 叶子节点
        if (level == h) {
            return 1;
        }
        if (mostLeft(cur.right, level + 1) == h) {
            // cur右树上的最左节点，到达了最深层
            // 就是说，cur的左树是满节点 (2^n-1) + 1
            return (1 << (h - level)) + f(cur.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
        }
    }

    //
    private int mostLeft(TreeNode cur, int level) {
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        return level - 1;
    }
}
