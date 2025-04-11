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

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    // 2. 搜索二叉树上寻找两个节点的最近公共祖先
    /**
     * root 从上到下
     * 如果先遇到p，p就是答案
     * 如果先遇到q，q就是答案
     * 如果root在p~q的值之间，不管p和q的大小，只要root在中间，root就是答案
     * 如果root在p~q的值的左侧，那么root往右移动
     * 如果root在p~q的值的右侧，那么root往左移动
     */
    public TreeNode lowestCommonAncesto2r(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val != p.val && root.val != q.val) {
            if (Math.min(p.val, q.val) < root.val && root.val < Math.max(p.val, q.val)) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }
}
