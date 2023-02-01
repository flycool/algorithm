package SwordOffer2;

/**
 * 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * <p>
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * 0 <= n <= 100
 */
public class Code10_2 {

    public static int frogJump(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        return frogJump(n - 1) + frogJump(n - 2);
    }

    public static int frogJump2(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;

    }

    public static void main(String[] args) {
        int i = frogJump2(7);
        System.out.println(i);
    }

}
