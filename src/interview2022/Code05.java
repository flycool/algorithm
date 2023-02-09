package interview2022;

import java.util.HashSet;

/**
 * 已知一颗二叉树上的所有值都不一样，
 * 给定这颗二叉树的头节点head，
 * 给定一个整型数组arr， arr里放着不同的值，每个值一定在树上，
 * 返回数组里所有值的最低公共祖先
 */
public class Code05 {

    public static void main(String[] args) {
        System.out.println(12);
    }

    public static class  TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return process(root, set, set.size()).find;
    }

    public static class Info {
        public TreeNode find;
        public int removes;
        public Info(TreeNode f, int removes) {
            find = f;
            this.removes = removes;
        }
    }

    public static Info process(TreeNode x, HashSet<Integer> set, int all) {
        if (x == null) {
            return new Info(null, 0);
        }
        Info left = process(x.left, set, all);
        if (left != null) {
            return left;
        }
        Info right = process(x.right, set, all);
        if (right != null) {
            return right;
        }
        int cur = set.contains(x.val) ? 1 : 0;
        set.remove(x.val);
        if (left.removes + right.removes + cur == all) {
            return new Info(x, all);
        } else {
            return new Info(null, left.removes + right.removes + cur);
        }

    }
}
