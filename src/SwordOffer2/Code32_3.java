package SwordOffer2;

import SwordOffer2.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 从上到下打印二叉树3
 *
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Code32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);//Inserts the specified element at the end of this deque.
        while (!deque.isEmpty()) {
            ArrayList<Integer> t = new ArrayList<>();//每层要放的节点
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
            if (ans.size() % 2 == 1) {
                Collections.reverse(t);
            }
            ans.add(t);
        }
        return ans;
    }
}
