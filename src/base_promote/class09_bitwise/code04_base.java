package base_promote.class09_bitwise;

//给定两个有符号32位整数a和b，不能使用算术运算符，分别实现a和b的加，减，乘，除运算
public class code04_base {

    //保证a+b不溢出
    /*
    异或：无进位相加
    等同于两数的异或与两数的与，再向左移一位(表示进位信息)相加
    (a^b) + (a&b)<<1
    直到进位信息没有了即为0时，那么异或的结果就是答案
     */
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //一个数的相反数就是：那个数取反再加1
    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {//看b的末尾是否为1，
                res = add(res, a);//是1，就累加a的左移一位的值，直到b为0
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    /**
     * 这里只考虑a和b都是整数情况
     * 首先让b向左一位一位的移动，看a能不能减到b，如果能，那一位上就是1，
     * 得到a-b的结果，重复上步骤，直到不能减为止
     */
    public static int div(int a, int b) {
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            while ((a >> i) >= b) {//选择a右移是因为，b左移可能会溢出
                res |= (1 << i);
                a = minus(a, b << i);
            }
        }
        return res;
    }
}
