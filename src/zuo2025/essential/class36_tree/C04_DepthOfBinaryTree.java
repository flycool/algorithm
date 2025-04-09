package zuo2025.essential.class36_tree;

class C04_DepthOfBinaryTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    //https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int ldeep = Integer.MAX_VALUE;
        int rdeep = Integer.MAX_VALUE;
        if (root.left != null) {
            ldeep = minDepth(root.left);
        }
        if (root.right != null) {
            rdeep = minDepth(root.right);
        }
        return Math.min(ldeep, rdeep) + 1;
    }
}

