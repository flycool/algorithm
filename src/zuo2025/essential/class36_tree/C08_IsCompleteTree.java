package zuo2025.essential.class36_tree;

public class C08_IsCompleteTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int maxn = 10001;
    private static TreeNode[] queue = new TreeNode[maxn];

    // 1. 有右无左，false
    // 2. 一旦发现孩子不全的节点，接下来必须全是叶节点，否则false
    // bfs
    // https://leetcode.com/problems/check-completeness-of-a-binary-tree/
    public boolean isCompleteTree(TreeNode h) {
        if (h == null) return true;

        int l = 0, r = 0;
        // 是否遇到左右孩子不双全的节点
        boolean isLeaf = false;
        queue[r++] = h;
        while (l < r) {
            h = queue[l++];
            if ((h.left == null && h.right != null) ||
                    (isLeaf && (h.left != null || h.right != null))
            ) {
                return false;
            }
            if (h.left != null) {
                queue[r++] = h.left;
            }
            if (h.right != null) {
                queue[r++] = h.right;
            }
            if (h.left == null || h.right == null) {
                isLeaf = true;
            }
        }
        return true;
    }
}
