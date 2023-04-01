package everyday;

import java.util.*;

//https://leetcode.cn/problem-list/2ckc81c/?page=1
public class LeetCodeTop {

    //125. 验证回文串
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String ss = sb.toString().toLowerCase();
        int l = 0, r = ss.length() - 1;
        while (l <= r) {
            if (ss.charAt(l++) != ss.charAt(r--)) {
                return false;
            }
        }
        return true;

    }

    //412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3) == 0 && (i % 5) == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }


    //387. 字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //326. 3 的幂
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //268. 丢失的数字
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int total = len * (len + 1) / 2;
        return total - sum;
    }


    //128. 最长连续序列
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLen += 1;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }


    //191. 位1的个数
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans++;
        }
        return ans;
    }

    //190. 颠倒二进制位
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ans |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }

    //50. Pow(x, n)
    public double myPow(double x, int n) {
        int pow = Math.abs(n);
        double ans = 1;
        double t = x;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                ans *= t;
            }
            t *= t;
            pow >>= 1;
        }
        return n > 0 ? ans : 1 / ans;
    }

    class Solution78 {
        private ArrayList<Integer> t = new ArrayList<>();
        private ArrayList<List<Integer>> ans = new ArrayList<>();

        // 78.子集
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
    }
}
