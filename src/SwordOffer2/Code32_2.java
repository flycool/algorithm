package SwordOffer2;

import SwordOffer2.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印二叉树2
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Code32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);//Inserts the specified element at the end of this deque.
        while (!deque.isEmpty()) {
            ArrayList<Integer> t = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();//the first element of the queue
                t.add(node.value);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
