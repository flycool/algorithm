package everyday;

import java.util.*;

public class 程序员面试金典6_medium {

    //输入: [5, 3, 1, 2, 3]
    //输出: [5, 1, 3, 2, 3]
    //面试题 10.11. 峰与谷
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    //面试题 16.02. 单词频率
    class WordsFrequency {
        private HashMap<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String s : book) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }

    //面试题 16.06. 最小差
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long min = Long.MAX_VALUE;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return 0;
            } else if (a[i] > b[j]) {
                min = Math.min(min, (long) a[i] - (long) b[j]);
                j++;
            } else {
                min = Math.min(min, (long) b[j] - (long) a[i]);
                i++;
            }
        }
        return (int) min;
    }

    private List<String> res = new ArrayList<>();

    //面试题 08.09. 括号
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dsf2(sb, 0, 0, n);
        return res;
    }

    private void dsf2(StringBuilder sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            dsf2(sb.append("("), left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            dsf2(sb.append(")"), left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private ArrayList<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    //面试题 08.04. 幂集
    public List<List<Integer>> subsets(int[] nums) {
        dsf(0, nums);
        return ans;
    }

    private void dsf(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dsf(cur + 1, nums);
        t.remove(t.size() - 1);
        dsf(cur + 1, nums);
    }

    //面试题 04.05. 合法二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        boolean isLeftBST = isValidBST(root.left);
        if (!isLeftBST) {
            return false;
        }
        if (root.val <= preValue) {
            return false;
        } else {
            preValue = root.val;
        }
        return isValidBST(root.right);
    }

    //面试题 04.03. 特定深度节点链表
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[]{};
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        deque.add(tree);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while (size-- > 0) {
                TreeNode node = deque.poll();
                head.next = new ListNode(node.val);
                head = head.next;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            list.add(dummy.next);
        }
        return list.toArray(new ListNode[list.size()]);
    }


    //面试题 03.05. 栈排序
    class SortedStack {
        private Stack<Integer> stack;
        private Stack<Integer> tempStack;

        public SortedStack() {
            stack = new Stack<>();
            tempStack = new Stack<>();
        }

        public void push(int val) {
            while (!stack.isEmpty() && stack.peek() < val) {
                int i = stack.pop();
                tempStack.push(i);
            }
            stack.push(val);
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int peek() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    //面试题 03.03. 堆盘子
    class StackOfPlates {
        private ArrayList<Deque<Integer>> stackList;
        private int mCap;

        public StackOfPlates(int cap) {
            mCap = cap;
            stackList = new ArrayList<>();
            stackList.add(new LinkedList<>());
        }

        public void push(int val) {
            if (mCap == 0) return;
            Deque<Integer> lastStack = stackList.get(stackList.size() - 1);
            if (lastStack.size() == mCap) {
                Deque<Integer> newStack = new LinkedList<>();
                newStack.push(val);
                stackList.add(newStack);
            } else {
                lastStack.push(val);
            }
        }

        public int pop() {
            return popAt(stackList.size() - 1);
        }

        public int popAt(int index) {
            if (mCap == 0) {
                return -1;
            }
            int stacksSize = stackList.size();
            if (index >= stacksSize) {
                return -1;
            }
            Deque<Integer> stack = stackList.get(index);
            int size = stack.size();
            if (size == 1) {
                int res = stack.pop();
                if (stacksSize > 1) {
                    stackList.remove(index);
                }
                return res;
            } else if (size > 0) {
                return stack.pop();
            } else {
                return -1;
            }
        }
    }

    //面试题 02.08. 环路检测
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //面试题 02.05. 链表求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = listToNumber(l1) + listToNumber(l2);
        ListNode dummy = new ListNode(0);
        if (sum == 0) {
            return dummy;
        }
        ListNode cur = dummy;
        //912
        while (sum != 0) {
            int val = sum % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            sum /= 10;

        }
        return dummy.next;
    }

    //716 -> 617
    private static int listToNumber(ListNode node) {
        int ans = 0;
        int c = 1;
        for (int i = 0; node != null; i++) {
            int cur = node.val;
            if (i == 0) {
                ans += cur;
            } else {
                c *= 10;
                ans += cur * c;
            }
            node = node.next;
        }
        return ans;
    }

    //输入：head = [1,4,3,2,5,2], x = 3
    //输出：[1,2,2,4,3,5]
    //面试题 02.04. 分割链表
    public ListNode partition(ListNode head, int x) {
        ListNode samll = new ListNode(0);
        ListNode smallHead = samll;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                samll.next = head;
                samll = samll.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        samll.next = largeHead.next;
        return smallHead.next;

    }

    //面试题 01.08. 零矩阵
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //面试题 01.05. 一次编辑
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (m - n == 1) {
            return oneCharInsert(second, first);
        } else if (n - m == 1) {
            return oneCharInsert(first, second);
        } else if (n == m) {
            boolean findDiff = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!findDiff) {
                        findDiff = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean oneCharInsert(String shorter, String longer) {
        int len1 = shorter.length(), len2 = longer.length();
        int index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
            }
            index2++;
            if ((index2 - index1) > 1) {
                return false;
            }
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
