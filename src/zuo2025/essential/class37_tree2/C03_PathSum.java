package zuo2025.essential.class37_tree2;

import java.util.ArrayList;
import java.util.List;

public class C03_PathSum {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // https://leetcode.com/problems/path-sum-iii/
    // 3. 收集累加和等于aim的所有路径（递归恢复现场）
    public List<List<Integer>> pathSum(TreeNode root, int aim) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> path = new ArrayList<>();
        f(root, aim, 0, path, ans);
        return ans;
    }

    // sum: 累加和
    private void f(TreeNode cur, int aim, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (cur.left == null && cur.right == null) {
            if (cur.val + sum == aim) {
                path.add(cur.val);
                ans.add(path);
                path.remove(path.size() - 1);
            }
        } else {
            path.add(cur.val);
            if (cur.left != null) {
                f(cur.left, aim, cur.val + sum, path, ans);
            }
            if (cur.right != null) {
                f(cur.right, aim, cur.val + sum, path, ans);
            }
            path.remove(path.size() - 1);
        }
    }
}
