package zuo2025.essential.class28_bitwise;

public class C02_BitwiseOperation2 {

    // 1. 判断一个正数是不是2的幂
    // https://leetcode.com/problems/power-of-two/
    public boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n & -n);
    }

    // 2. 判断一个正数是不是3的幂
    // https://leetcode.com/problems/power-of-three/
    // 如果某个数是3的幂，那么它只含有3这个质数因子
    // 1162261467是int型范围内，最大的3的幂，它是3的19次方
    public boolean isPowerOfTree(int n) {
        return n > 0 && (1162261467 % n) == 0;
    }

    // 3. 返回大于等于n的最小的2幂
    // 把从最左边的1开始，一直到最右都变为1
    public int near2Power(int n) {
        if (n < 0) return 1;
        n--; // 保证n是2的幂时，返回n
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    // 4. 区间[left, right] 内所有数值 & 的结果
    // https://leetcode.com/problems/bitwise-and-of-numbers-range/
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right -= right & -right; // 减去最右侧的1
        }
        return right;
    }

    // 5. 反转一个二进制的状态，不是0变1，1变0，是逆序。超自然版
    // https://leetcode.com/problems/reverse-bits/
    // 先11对交换，再22交换，。。。16和16位交换
    public int reverseBits(int n) {
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = (n >>> 16) | (n << 16);
        return n;
    }

    // 6. 返回一个数二进制中有几个1
    // 把n转换成以二进制表示多少个1的形式
    public int cntOnes(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555); // 转换为长度位2位的含义
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff); // 长度位32位的含义
        return n;
    }

    // 汉明距离
    // 两个整数之间的汉明距离是对应比特位不同的位置数
    // https://leetcode.com/problems/hamming-distance/
    public int hammingDistance(int x, int y) {
        return cntOnes(x ^ y);
    }

}
