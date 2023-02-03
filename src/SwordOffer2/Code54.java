package SwordOffer2;
import SwordOffer2.datastruct.TreeNode;

/**
 * 二叉搜索树的第 k 大节点
 *
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * 中序遍历的顺序是从小到大，倒序的中序遍历便是从大到小。
 */
public class Code54 {
    private int cur;
    private int res;

    //反向中序遍历，从大到小
    public int kthLargest(TreeNode root, int k) {
        cur = k;
        res = 0;
        reverseInOrder(root);
        return res;
    }

    private void reverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseInOrder(root.right);
        --cur;
        if (cur == 0) {
            res = root.value;
            return;
        }
        reverseInOrder(root.left);
    }

}
