package struct.trie;

import java.util.HashSet;

/**
 * 2.
 * 数组中两个数的最大异或值
 * 给你一个整数数组nums,返回nums[i] XOR nums[j]的最大运算结果，其中O<=i<=j<=n
 * 1 <nums.length <2 10^5
 * 0<=nums[i]<=2^31-1
 * 前缀树做法&哈希表做法
 * 时间复杂度0(n*logV,空间复杂度0(n*1ogV,V是数值范围，logV是以10为底
 */
public class Code02_TwoNumbersMaximumXOR {

    //前缀树做法
    public int findMaximumXOR(int[] nums) {
        build(nums);
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, maxXor(num));
        }
        clear();
        return ans;
    }

    private static final int max = 300001;
    private static final int[][] tree = new int[max][2];
    private static int cnt;
    private int hight; // 最大数字的最高位

    public void build(int[] nums) {
        cnt = 1;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        hight = 31 - Integer.numberOfLeadingZeros(maxNum);
        for (int num : nums) {
            insert(num);
        }
    }

    public void insert(int num) {
        int cur = 1;
        for (int i = hight, path; i >= 0; i--) {
            path = (num >> i) & 1; //num 第i位的状态
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    public int maxXor(int num) {
        int cur = 1;
        int ans = 0;
        for (int i = hight, status, expect; i >= 0; i--) {
            status = (num >> i) & 1;
            expect = status ^ 1;
            if (tree[cur][expect] == 0) {
                expect ^= 1;
            }
            ans |= (status ^ expect) << i;
            cur = tree[cur][expect];
        }
        return ans;
    }

    public void clear() {
        for (int i = 1; i <= cnt; i++) {
            tree[i][0] = tree[i][1] = 0;
        }
    }

    //hash表做法
    public int findMaximumXOR2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        int high = 31 - Integer.numberOfLeadingZeros(max);
        for (int i = high; i >=0 ; i--) {
            int better = ans | (1 << i);
            set.clear();
            for (int num : nums) {
                // num: 保留 31...i 这些状态，剩下的设为0
                num = (num >> i) << i;
                set.add(num);
                if (set.contains(better ^ num)) {
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }
}
