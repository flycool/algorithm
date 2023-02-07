package SwordOffer2;

/**
 * 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Code65 {

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // 得到进位
            a ^= b; // 不进位相加
            b = c;
        }
        return a;
    }
}
