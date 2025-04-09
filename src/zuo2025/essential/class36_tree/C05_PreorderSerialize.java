package zuo2025.essential.class36_tree;

public class C05_PreorderSerialize {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        f(root, builder);
        return builder.toString();
    }

    private void f(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#").append(",");
        } else {
            builder.append(root.val);
            f(root.left, builder);
            f(root.right, builder);
        }
    }

    private static int cnt;

    public TreeNode deSerialize(String data) {
        String[] vals = data.split(",");
        cnt = 0;
        return g(vals);
    }

    private TreeNode g(String[] vals) {
        String cur = vals[cnt++];
        if (cur.equals("#")) {
            return null;
        } else {
            TreeNode head = new TreeNode(Integer.valueOf(cur));
            head.left = g(vals);
            head.right = g(vals);
            return head;
        }
    }


}

