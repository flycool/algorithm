package interview2022;

//求二叉树的最小深度
public class Code16_MinDepth {

    public class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }

    public int ans = Integer.MAX_VALUE;
    public int minDepth(Tree root) {
        if (root == null) {
            return 0;
        }
        wen(root, 0);
        return ans;
    }

    private void wen(Tree root, int level) {
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, level);
        } else {
            if (root.left != null) {
                wen(root.left, level + 1);
            }
            if (root.right != null) {
                wen(root.right, level + 1);
            }
        }
    }


}
