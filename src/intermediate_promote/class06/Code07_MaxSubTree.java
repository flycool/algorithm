package intermediate_promote.class06;

public class Code07_MaxSubTree {

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //找到一颗二叉树中，最大的搜索二叉子树，返回其子树的head
    private static class Info {
        public boolean isBst;
        public int maxSize;
        public Node subHead;
        public int maxValue;
        public int minValue;

        public Info(boolean isBst, int maxSize, Node subHead, int maxValue, int minValue) {
            this.isBst = isBst;
            this.maxSize = maxSize;
            this.subHead = subHead;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }

    public static Info getMaxHead(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = getMaxHead(x.left);
        Info rightInfo = getMaxHead(x.right);

        int min = x.value;
        int max = x.value;
        int maxSize = 0;
        Node maxHead = null;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.minValue);
            max = Math.max(max, leftInfo.maxValue);
            maxSize = leftInfo.maxSize;
            maxHead = leftInfo.subHead;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.minValue);
            max = Math.max(max, rightInfo.maxValue);
        }

        if (rightInfo != null && rightInfo.maxValue > maxSize) {
            maxSize = rightInfo.maxSize;
            maxHead = rightInfo.subHead;
        }

        boolean isBst = false;
        if ((leftInfo == null || leftInfo.isBst) && (rightInfo == null || rightInfo.isBst)) {
            if ((leftInfo == null || leftInfo.maxValue < x.value) && (rightInfo == null || x.value > rightInfo.minValue)) {
                isBst = true;
                maxHead = x;
                int leftSize = leftInfo == null ? 0 : leftInfo.maxSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.maxSize;
                maxSize = leftSize+ 1 + rightSize;
            }
        }
        return new Info(isBst, maxSize, maxHead, max, min);
    }
}
