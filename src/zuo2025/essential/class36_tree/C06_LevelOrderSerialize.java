package zuo2025.essential.class36_tree;

public class C06_LevelOrderSerialize {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int maxn = 10001;
    private static TreeNode[] queue = new TreeNode[maxn];

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public String levelOrderSerialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return "";
        }
        int l = 0, r = 0;
        builder.append(root.val).append(",");
        queue[r++] = root;
        while (l < r) {
            root = queue[l++];
            if (root.left != null) {
                builder.append(root.left.val).append(",");
                queue[r++] = root.left;
            } else {
                builder.append("#,");
            }
            if (root.right != null) {
                builder.append(root.right.val).append(",");
                queue[r++] = root.right;
            } else {
                builder.append("#,");
            }
        }
        return builder.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodes = data.split(",");
        int index = 0;
        TreeNode root = generate(nodes[index++]);
        int l = 0, r = 0;
        queue[r++] = root;
        while (l < r) {
            TreeNode cur = queue[l++];
            cur.left = generate(nodes[index++]);
            cur.right = generate(nodes[index++]);
            if (cur.left != null) {
                queue[r++] = cur.left;
            }
            if (cur.right != null) {
                queue[r++] = cur.right;
            }
        }
        return root;
    }

    private TreeNode generate(String val) {
        return val.equals("#") ? null : new TreeNode(Integer.parseInt(val));
    }
}
