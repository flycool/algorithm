package SwordOffer2;

import SwordOffer2.datastruct.TreeNode;

/**
 *对称的二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Code28 {

    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.value != b.value) {
            return false;
        }
        return dfs(a.left, b.right) && dfs(a.right, b.left);
    }
}
