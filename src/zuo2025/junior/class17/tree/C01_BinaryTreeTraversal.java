package zuo2025.junior.class17.tree;

public class C01_BinaryTreeTraversal {

    public static class TreeNode {
        private final int value;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // 递归先序遍历
    public void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 递归中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    // 递归后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}
