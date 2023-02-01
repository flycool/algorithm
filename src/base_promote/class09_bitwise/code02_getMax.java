package base_promote.class09_bitwise;

/**
 * 给定两个有符号32位整数a和b，返回a和b中较大的
 * 要求：不用做任何比较判断
 */
public class code02_getMax {

    /**
     * n 的值为1或0
     * 1^1 = 0
     * 0^1 = 1
     */
    public static int flip(int n) {
        return n ^ 1;
    }

    //n为非负数，返回 1
    //n为负数，返回 0
    public static int sign(int n) {
        return flip((n >> 31 & 1)); //n>>31表示 n的符号位(最高位)移到最右边
    }

    public static int getMax1(int a, int b) {
        int c = a - b;//可能会溢出
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int diffSab = sa ^ sb;
        int sameSab = flip(diffSab);
        //返回a的条件
        //1.a和b的符号不相同，且a>0
        //2.a和b的符号相同，且a-b>=0
        int returnA = diffSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int max1 = getMax2(4, 6);
        System.out.println(max1);
    }
}
