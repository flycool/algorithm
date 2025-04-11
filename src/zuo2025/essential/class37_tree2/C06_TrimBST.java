package zuo2025.essential.class37_tree2;

public class C06_TrimBST {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 6. 修剪搜索二叉树
    // https://leetcode.com/problems/trim-a-binary-search-tree/
    public TreeNode trimBST(TreeNode cur, int low, int high) {
        if (cur == null) {
            return null;
        }
        if (cur.val < low) {
            return trimBST(cur.right, low, high);
        }
        if (cur.val > high) {
            return trimBST(cur.left, low, high);
        }
        cur.left = trimBST(cur.left, low, high);
        cur.right = trimBST(cur.right, low, high);
        return cur;
    }
}
