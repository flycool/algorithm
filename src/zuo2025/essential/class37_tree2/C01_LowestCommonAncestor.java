package zuo2025.essential.class37_tree2;

public class C01_LowestCommonAncestor {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 1. 普通二叉树寻找两个节点的最近公共祖先
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }
        if (l == null && r == null) {
            return null;
        }
        return l != null ? l : r;
    }
}
