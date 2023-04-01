package everyday;

import java.util.*;

public class LeetCodeTest {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int r = -1, l = -1;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }
            if (min < nums[n - i - 1]) {
                l = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return r == -1 ? 0 : r - l + 1;
    }

    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int count = 0;
        while (ans != 0) {
            ans &= (ans - 1);
            count++;
        }
        return count;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        map.forEach((key, value) -> {
            int[] a = {key, value};
            queue.add(a);
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int mCapacity = 0;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            mCapacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > mCapacity;
        }
    }


    class MinStack {
        private Stack<Integer> minStack;
        private Stack<Integer> stack;

        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            minStack.push(Math.min(minStack.peek(), val));
            stack.push(val);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            ans = Math.max(ans, prices[i] - minPrice);
        }
        return ans;
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
