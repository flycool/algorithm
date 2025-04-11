package zuo2025.essential.class37_tree2;

public class C05_ValidateBinarySearchTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 5. 验证搜索二叉树
    // https://leetcode.com/problems/validate-binary-search-tree/
    private long min, max;

    public boolean isValidBST(TreeNode head) {
        if (head == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        boolean lok = isValidBST(head.left);
        long lmin = min;
        long lmax = max;
        boolean rok = isValidBST(head.right);
        long rmin = min;
        long rmax = max;
        min = Math.min(Math.min(lmin, rmin), head.val);
        max = Math.max(Math.max(lmax, rmax), head.val);

        return lok && rok && lmax < head.val && head.val < rmin;
    }
}
