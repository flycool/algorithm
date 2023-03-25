package interview2022;

/*
给定一个二叉树，你需要计算它的直径长度。
一颗二叉树的直径长度是任意连个结点路径长度中的最大值。
这条路径可能穿过也可能不穿过根结点。
 */
public class Code30_MaxDistance {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public int maxDistance(TreeNode x) {
        return process(x).maxDistance;
    }

    public Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        //与x无关
        int p1 = Math.max(leftInfo.maxDistance, rightInfo.maxDistance);
        //与x有关
        int p2 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(p1, p2);
        return new Info(maxDistance, height);

    }
}
