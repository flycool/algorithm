package interview2022;
import interview2022.datastruct.MyHash;

/**
 * 43  求相等子树的数量
 * 如果一个结点x，它左树结构和右树结构完全一样
 * 那么我们说以x为头的子树是相等子树
 * 给定一颗二叉树的头结点head
 * 返回head整颗树上有多少颗相等子树
 */
public class Code43_SameTree {

    public class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }

    //O(logn*n)
    public int sameTree1(Tree head) {
        if (head == null) {
            return 0;
        }
        return sameTree1(head.left) + sameTree1(head.right) + (same(head.left, head.right) ? 1 : 0);
    }

    private boolean same(Tree h1, Tree h2) {
        if (h1 == null ^ h2 == null) {//其中一个为空，另一个不为空 true ^ false = true
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && same(h1.left, h2.left) && same(h1.right, h2.right);
    }

    //O(n)
    public int sameTree2(Tree head) {
        return process(head, new MyHash("SHA-256")).ans;
    }

    public class Info {
        public int ans;
        public String hashCode;
        public Info(int ans, String hashCode) {
            this.ans = ans;
            this.hashCode = hashCode;
        }
    }

    public Info process(Tree head, MyHash hash) {
        if (head == null) {
            return new Info(0, hash.hashCode("#,"));
        }
        Info l = process(head.left, hash);
        Info r = process(head.right, hash);
        int ans = l.ans + r.ans + (l.hashCode.equals(r.hashCode) ? 1 : 0);
        String str = hash.hashCode(String.valueOf(head.val) + "," + l.hashCode + r.hashCode);
        return new Info(ans, str);
    }
}
