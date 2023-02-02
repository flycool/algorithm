package SwordOffer2;

/**
 * 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Code27 {

    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    //递归
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
