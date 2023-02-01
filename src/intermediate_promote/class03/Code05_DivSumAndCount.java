package intermediate_promote.class03;

import java.awt.geom.Dimension2D;

/**
 * 假设s和m初始化，s="a"; m = s;
 * 再定义两种操作，
 * 第一种操作：
 * m = s;
 * s = s + s;
 * 第二种操作：
 * s = s + m
 * 求最小的操作步骤数，可以将s拼接到长度等于n
 * 1.如果n为质数，选第二种操作最优，为n-1
 * 2.如果n不为质数，那么 n=x*Y*z*.. (x,y,z都为质数)，结果为(x+y+z)-3. 3为质数因子的个数
 */
public class Code05_DivSumAndCount {
    //是否为质数
    public static boolean isPrime(int n) {
        if (n > 0 && n < 3) {
            return true;
        }
        int max = (int) Math.sqrt(n);
        for (int i = 3; i <= max; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] divSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }

    public static int minOps(int n) {
        if (n < 2) {
            return 0;
        }
        if (isPrime(n)) {
            return n - 1;
        }
        int[] divSumAndCount = divSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPrime(n));
    }
}
