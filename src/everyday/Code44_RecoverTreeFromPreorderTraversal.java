package everyday;

/**
 * 44. 根据字符串来重建二叉树
 */
public class Code44_RecoverTreeFromPreorderTraversal {

    public int[] queue = new int[2001];

    int l, r;

    // 1-2--3---4-5--6---7
    public TreeNode recoverFromPreorderTree(String traversal) {
        l = 0;
        r = 0;
        int level = 0;
        int num = 0;
        boolean pickLevel = true;
        for (int i = 0; i < traversal.length(); i++) {
            if (traversal.charAt(i) != '-') {
                if (pickLevel) {
                    queue[r++] = level;
                    level = 0;
                    pickLevel = false;
                }
                num = num * 10 + traversal.charAt(i) - '0';
            } else {
                if (!pickLevel) {
                    queue[r++] = num;
                    num = 0;
                    pickLevel = true;
                }
                level++;
            }
        }
        queue[r++] = num;
        return f();
    }

    private TreeNode f() {
        int level = queue[l++];
        TreeNode head = new TreeNode(queue[l++]);
        if (l < r && queue[l] > level) {
            head.left = f();
        }
        if (l < r && queue[l] > level) {
            head.right = f();
        }
        return head;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
