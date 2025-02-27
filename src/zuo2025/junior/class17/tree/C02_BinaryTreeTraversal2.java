package zuo2025.junior.class17.tree;

import java.util.Stack;

public class C02_BinaryTreeTraversal2 {

    public static class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

    /**
     *
     * 非递归实现二叉树的先序、中序、后序遍历
     * 使用栈来模拟递归过程
     */

    // 非递归先序遍历
    public void preOrder(TreeNode root) {
        if (root == null) return;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            System.out.println(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        System.out.println();
    }

    // 非递归中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) return;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.val + " ");
                cur = cur.right;
            }
        }
        System.out.println();
    }

    // 非递归后序遍历
    public void postOrder(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(cur.left != null && root !=cur.left && root != cur.right) {
                stack.push(cur.left);
            } else if(cur.right!=null && root != cur.right) {
                stack.push(cur.right);
            } else {
                System.out.println(cur.val + " ");
                root = stack.pop();
            }
        }
        System.out.println();
    }
}
