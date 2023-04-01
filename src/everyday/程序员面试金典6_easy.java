package everyday;


import java.util.List;

public class 程序员面试金典6_easy {


    //面试题 17.16. 按摩师
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int first = 0, second = 0;
        for (int num : nums) {
            int tmp = second;
            second = Math.max(second, first + num);
            first = tmp;
        }
        return second;
    }


    //面试题 17.10. 主要元素
    public int majorityElement(int[] nums) {
        int c = nums.length / 2 + 1;
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count >= c ? candidate : -1;
    }

    //面试题 17.04. 消失的数字
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int total = (n + 1) * n / 2;
        return total - sum;
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }
        return a;
    }

    //面试题 16.17. 连续数列
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            max = Math.max(max, cur);
            cur = Math.max(cur, 0);
        }
        return max;
    }

    //面试题 16.11. 跳水板
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i] = longer * i + shorter * (k - i);
        }
        return ans;
    }

    //面试题 16.05. 阶乘尾数
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

    //面试题 10.05. 稀疏数组搜索
    public int findString(String[] words, String s) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if ("".equals(words[i])) {
                continue;
            }
            if (words[i].equals(s)) {
                ans = i;
            }
        }
        return ans;
    }

    //面试题 10.01. 合并排序的数组
    public void merge(int[] A, int m, int[] B, int n) {
        int ra = m - 1, rb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (ra >= 0 || rb >= 0) {
            if (ra == -1) {
                cur = B[rb--];
            } else if (rb == -1) {
                cur = A[ra--];
            } else if (A[ra] > B[rb]) {
                cur = A[ra--];
            } else {
                cur = B[rb--];
            }
            A[tail--] = cur;
        }
    }

    //面试题 08.06. 汉诺塔问题
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, C, B, A.size());
    }

    private void move(List<Integer> a, List<Integer> c, List<Integer> b, int size) {
        if (size == 1) {
            c.add(a.remove(a.size() - 1));
            return;
        }
        move(a, b, c, size - 1);
        c.add(a.remove(a.size() - 1));
        move(b, c, a, size - 1);
    }

    //面试题 08.03. 魔术索引
    public int findMagicIndex(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    //面试题 08.01. 三步问题
    public int waysToStep(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i - 3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }


    //面试题 05.07. 配对交换
    //110101
    public int exchangeBits(int num) {
        int odd = num & 0x55555555;
        int even = num & 0xaaaaaaaa;
        odd <<= 1;
        even >>>= 1;
        return odd | even;
    }


    //面试题 05.06. 整数转换
    public int convertInteger(int A, int B) {
        int ans = A ^ B;
        int count = 0;
        while (ans != 0) {
            ans &= (ans - 1);
            count++;
        }
        return count;
    }

    //面试题 05.03. 翻转数位
    public int reverseBits(int num) {
        int max = 0;
        int reverse = 0;
        int current = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                current++;
                reverse++;
            } else {
                reverse = current + 1;
                current = 0;
            }
            if (reverse > max) max = reverse;
            num >>= 1;
        }
        return max;
    }

    //面试题 05.01. 插入
    public int insertBits(int N, int M, int i, int j) {
        int left = N >> j >> 1;
        left = left << j << 1;
        int middle = M << i;
        int right = N & ((1 << i) - 1);
        return left | middle | right;
    }

    //面试题 01.09. 字符串轮转
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s2).contains(s2);
    }

    //面试题 01.06. 字符串压缩
    public String compressString(String S) {
        int n = S.length();
        if (n == 0) {
            return "";
        }
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char prec = S.charAt(0);
        for (int i = 1; i < n; i++) {
            if (prec == S.charAt(i)) {
                count++;
            } else {
                sb.append(prec).append(count);
                prec = S.charAt(i);
                count = 1;
            }
        }
        sb.append(prec).append(count);
        return sb.toString().length() >= n ? S : sb.toString();

    }


    //面试题 01.04. 回文排列
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        int[] map = new int[256];
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)]++;
        }
        int count = 0;
        for (int i : map) {
            if (i % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }

    //面试题 01.03. URL化
    public static String replaceSpaces(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

    //面试题 01.02. 判定是否互为字符重排
    public boolean CheckPermutation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) return false;

        int[] map = new int[128];
        for (int i = 0; i < n1; i++) {
            map[s1.charAt(i)]++;
        }
        for (int i = 0; i < n2; i++) {
            map[s2.charAt(i)]--;
            if (map[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    //面试题 01.01. 判定字符是否唯一
    public boolean isUnique(String astr) {
        int len = astr.length();
        if (len > 26) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if ((num & (1 << index)) != 0) {
                return false;
            } else {
                num |= (1 << index);
            }
        }
        return true;
    }
}
