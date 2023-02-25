package leetcode;

//85 leetcode 0326 是否是3的幂
public class p_0326_is3Mi {

    public static boolean is3mi(int n) {
        if (n < 3) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        boolean mi = is3mi(27);
        System.out.println(mi);
    }
}
