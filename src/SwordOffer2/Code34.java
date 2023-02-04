package SwordOffer2;
import SwordOffer2.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code34 {

    private List<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }
    private void dfs(TreeNode root, int s) {
        if (root == null) {
            return;
        }
        t.add(root.value);
        s -= root.value;
        if (root.left == null && root.right == null && s == 0) {
            ans.add(new ArrayList<>(t));
        }
        dfs(root.left, s);
        dfs(root.right, s);
        t.remove(t.size() - 1);
    }

}
