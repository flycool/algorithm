package zuo2025.essential.class37_tree2;

public class C07_HouseRobberIII {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 完成x子树遍历后，
    // yes变成，x子树在偷头节点的情况下，最大收益
    private int yes;
    // 完成x子树遍历后，
    // yes变成，x子树在不偷头节点的情况下，最大收益
    private int no;

    // https://leetcode.com/problems/house-robber-iii/
    public int rob(TreeNode root) {
        f(root);
        return Math.max(yes, no);
    }

    public void f(TreeNode root) {
        if (root == null) {
            yes = 0;
            no = 0;
        } else {
            int y = root.val;
            int n = 0;
            f(root.left);
            y += no;
            n += Math.max(yes, no);
            f(root.right);
            y += no;
            n += Math.max(yes, no);
            yes = y;
            no = n;
        }
    }
}
