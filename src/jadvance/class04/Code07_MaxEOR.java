package jadvance.class04;

public class Code07_MaxEOR {
    /**
     * 数组异或和的定义：把数组中所有的数异或和起来得到的值。
     * 给定一个整形数组arr，其中可能有正，负，零，求其中子数组的最大异或和
     */
    public static int maxEOR1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //预处理 arr[0..i]的异或和
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = arr[i] ^ preSum[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int start = 0; start <= i; start++) {
                //求出 arr[start..i] 这个子数组的异或和
                //arr[start..i]的异或和 = arr[0..i]的异或和 ^ arr[0..start-1]的异或和
                int sum = preSum[i] ^ (start - 1 == -1 ? 0 : preSum[start - 1]);
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    //==============================
    //前缀树
    public static class Node {
        public Node[] nexts = new Node[2];
    }

    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxXor(int sum) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (sum >> move) & 1;
                int best = move == 31 ? path : (path ^ 1);
                if (cur != null) {
                    best = cur.nexts[best] != null ? best : (best ^ 1);
                    res |= (path ^ best) << move;
                    cur = cur.nexts[path];
                }
            }
            return res;
        }
    }

    public static int maxEOR2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
            max = Math.max(max, numTrie.maxXor(sum));
            numTrie.add(sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 8, 7, 59, 5};
        int i = maxEOR1(arr);
        int i1 = maxEOR2(arr);
        System.out.println(i);
        System.out.println(i1);
    }
}
