package base_promote.class09_bitwise;

/**
 * 判断一个32位正数是不是2的幂，4的幂
 */
public class code03_power {

    //二进制中只有一个1
    public static boolean is2Power(int n) {
        return (n & (n - 1)) == 0;
    }

    public static boolean is4Power(int n) {
        //0x55555555 为 ...01010101
        return is2Power(n) && (n & 0x55555555) != 0;
    }
}
