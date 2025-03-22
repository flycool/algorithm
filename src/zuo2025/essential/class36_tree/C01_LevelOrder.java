package zuo2025.essential.class36_tree;

import java.util.ArrayList;
import java.util.List;

public class C01_LevelOrder {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    private final int n = 2001;
    private final TreeNode[] queue = new TreeNode[n];

    // 1. 二叉树的层序遍历
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        int l = 0, r = 0;
        queue[r++] = root;
        while (l < r) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int size = r - l;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                levelList.add(cur.val);
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(levelList);
        }
        return ans;
    }
}
