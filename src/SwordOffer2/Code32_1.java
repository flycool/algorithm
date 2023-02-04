package SwordOffer2;

import SwordOffer2.datastruct.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 从上到下打印二叉树1
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Code32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);//Inserts the specified element at the end of this deque.
        ArrayList<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();//the first element of the queue
                res.add(node.value);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
