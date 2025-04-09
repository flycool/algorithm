package zuo2025.essential.class36_tree;

public class C03_WidthOfBinaryTree {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    private final int n = 3001;
    private final TreeNode[] nq = new TreeNode[n];
    private final int[] iq = new int[n];

    // https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        int l = 0, r = 0;
        nq[r] = root;
        iq[r++] = 1;
        while (l < r) {
            ans = Math.max(ans, iq[r - 1] - iq[l] + 1);
            int size = r - l;
            for (int i = 0; i < size; i++) {
                TreeNode cur = nq[l];
                int id = iq[l++];
                if (cur.left != null) {
                    nq[r] = cur.left;
                    iq[r++] = id * 2;
                }
                if (cur.right != null) {
                    nq[r] = cur.right;
                    iq[r++] = id * 2 + 1;
                }
            }
        }
        return ans;
    }
}
