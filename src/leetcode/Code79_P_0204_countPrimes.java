package leetcode;

/**
 * 79 leetcode 0204 计算质数
 * 返回1~n中的素数
 * （插空法）
 * 跳过一些重复试的数
 */
public class Code79_P_0204_countPrimes {

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = n / 2;//去掉偶数剩下的数量
        // 不是素数，f[i] = true
        boolean[] f = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            if (f[i]) {
                continue;
            }
            // 3*3=9 3*5=15 3*7=21
            for (int j = i * i; j < n; j += 2 * i) { // i*i 肯定不是素数嘛，所以减掉
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
}
