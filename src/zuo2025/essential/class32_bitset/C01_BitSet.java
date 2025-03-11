package zuo2025.essential.class32_bitset;

import zuo2025.algorithm.Code01_Bitset;

public class C01_BitSet {

    // 位图原理：
    // 就是用bit组成的数组来存放值，用bit状态1，0代表存在与否，取值和存值操作都用位运算
    // 限制是必须为连续范围且不能过大。好处是极大的节省空间。
    private static class BitSet {
        public int[] set;

        public BitSet(int n) {
            // a/b 如果向上取整，(a+b-1)/b (a, b 非负数)
            set = new int[(n + 31) / 32];
        }

        public void add(int num) {
            set[num / 32] |= 1 << (num % 32);
        }

        public void remove(int num) {
            set[num / 32] &= ~(1 << (num % 32));
        }

        public void reverse(int num) {
            set[num / 32] ^= 1 << (num % 32);
        }

        public boolean contains(int num) {
            return ((set[num / 32] >> (num % 32)) & 1) == 1;
        }
    }

    // https://leetcode-cn.com/problems/design-bitset
    private static class BitSet2 {
        private int[] set;
        private final int size;
        private int zeros;
        private int ones;
        private boolean reverse;

        public BitSet2(int n) {
            set = new int[(n + 31) / 32];
            size = n;
            zeros = n;
            ones = 0;
            reverse = false;
        }

        // 把i位置的状态设置成1
        public void fix(int i) {
            int index = i / 32;
            int bit = i % 32;
            if (!reverse) {
                if ((set[index] & 1 << bit) == 0) {
                    zeros--;
                    ones++;
                    set[index] |= 1 << bit;
                }
            } else {
                if ((set[index] & 1 << bit) != 0) {
                    zeros--;
                    ones++;
                    set[index] ^= 1 << bit;
                }
            }
        }

        public void unfix(int i) {
            int index = i / 32;
            int bit = i % 32;
            if (!reverse) {
                if ((set[index] & 1 << bit) != 0) {
                    ones--;
                    zeros++;
                    set[index] ^= 1 << bit;
                }
            } else {
                if ((set[index] & 1 << bit) == 0) {
                    ones--;
                    zeros++;
                    set[index] |= 1 << bit;
                }
            }
        }

        public void flip() {
            reverse = !reverse;
            int tmp = zeros;
            zeros = ones;
            ones = tmp;
        }

        public boolean all() {
            return ones == size;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, k = 0, number, status; i < size; k++) {
                number = set[k];
                for (int j = 0; j < 32 && i < size; j++, i++) {
                    status = (number >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    builder.append(status);
                }
            }
            return builder.toString();
        }
    }
}
