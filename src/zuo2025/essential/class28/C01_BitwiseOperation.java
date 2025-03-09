package zuo2025.essential.class28;

public class C01_BitwiseOperation {

    /**
     * 异或运算的性质：
     * 1. 异或运算就是无进位相加
     * 2. 异或运算满足交换律，结合律，也就是同一批数字，不管异或顺序是什么，结果都一样
     * 3. 0^n=n, n^n=0
     * 4. 整体异或和如果是x，整体中某个部分的异或和如果是y，那么剩下部分的异或和就是 x^y
     */

    /**
     * i， j 的值必须不同
     * 如果 i==j arr[i]^arr[j] = 0， 会出错 （把原来的值变为0了）
     * 所以不推荐
     */
    // 1. 交换两个数
    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // 2. 不用任何判断语句和比较操作，返回两个数的最大值
    // n 保证1 或 0
    // 反转0，1
    private int flip(int n) {
        return n ^ 1;
    }

    // 获取n的符号位, 并反转
    // 1: 非负数；0: 负数
    private int sign(int n) {
        return flip(n >>> 31);
    }

    public int getMax1(int a, int b) {
        int c = a - b; // c 可能会溢出
        int returnA = sign(c);
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    // 优化的
    public int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        // a, b一样符号，diffAB=1
        int diffAB = sa ^ sb;
        int sameAB = flip(diffAB);

        // return a 的条件：
        // 1. a, b 一样符号，a-b>=0 (sa为1)
        // 2. a, b 符号不一样，sc 非负
        int returnA = diffAB * sa + sameAB * sc;
        int returnB = flip(returnA);

        return a * returnA + b * returnB;
    }

    // 3. 找到缺失的数字
    // https://leetcode-cn.com/problems/missing-number/
    public int findMissNumber(int[] arr) {
        int xorAll = 0, xorHas = 0;
        for (int i = 0; i < arr.length; i++) {
            xorAll ^= i;
            xorHas ^= arr[i];
        }
        xorAll ^= arr.length;
        return xorAll ^ xorHas;
    }

    // 4. 数组中1种数出现了奇数次，其他的数都出现了偶数次，返回出现了奇数次的数
    // https://leetcode-cn.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }

    // 5. 数组中有2种数出现了奇数次，其他的数都出现了偶数次，返回这2种出现了奇数次的数
    // Brian Kernighan 算法，提取出二进制状态种最右侧的1 : n&(-n)
    // https://leetcode-cn.com/problems/single-number-iii/

    // 解释：a和b肯定不一样，则 a^b 中某位肯定为1，
    // 通过这个1，将数组分为两组，a和b分别在两组中
    // 在原数组，根据以上的1，将数组分为两组，分别异或，得到a和b
    public int[] singleNumber2(int[] nums) {
        int eor1 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }
        int rightOne = eor1 & (-eor1);
        int eor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) { // 选其中一组异或
                eor2 ^= num;
            }
        }
        return new int[]{eor2, eor1 ^ eor2};
    }

    // 6. 数组中有1种数出现次数少于m次，其他的数都出现了m次，返回出现次数小于m次的那种数
    public int findLessMNumber(int[] arr, int m) {
        // cnt[0]: 0位上有多少个1
        // cnt[i]: i位上有多少个1
        // cnt[31]: 32位上有多少个1
        int[] cnts = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                cnts[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 第i位累加值不是m的正数倍, 说明这位上是1
            if (cnts[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
