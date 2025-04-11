package zuo2025.essential.class37_tree2;

public class C04_BalanceBinaryTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean isBalance;

    // 4. 验证平衡二叉树
    // https://leetcode.com/problems/balanced-binary-tree/
    public boolean isBalanceTree(TreeNode root) {
        isBalance = true;
        height(root);
        return isBalance;
    }

    public int height(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int lh = height(cur.left);
        int rh = height(cur.right);
        if (Math.abs(lh - rh) > 1) {
            isBalance = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
