package leetcode;

/**
 * 78 leetcode 0190 颠倒二进制位
 * n的高16位和n的低16位交换
 * 在16位里，n的高8位和n的低8位交换
 * 依次类推
 */
public class P_0190_ReverseBits {

    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
