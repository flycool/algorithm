package jadvance.class04;

public class Code03_SplitNumber {
    /**
     * 给定一个正数n，求裂开的方法数，递增的方法裂开
     * 动态规划优化状态依赖的技巧
     */
    public static int splitNumber(int n) {
        if (n < 1) {
            return 0;
        }
        return process(1, n);
    }

    public static int process(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (pre > rest) {
            return 0;
        }
        int ans = 0;
        for (int i = pre; i <= rest; i++) {
            ans += process(i, rest - i);
        }
        return ans;
    }

    public static int ways2(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int pre = 1; pre < dp.length; pre++) {
            dp[pre][0] = 1;
        }
        for (int pre = n; pre > 0; pre--) {
            for (int rest = pre; rest <= n; rest++) {
                for (int i = pre; i <= rest; i++) {
                    dp[pre][rest] += dp[i][rest - i];
                }
            }
        }
        return dp[1][n];
    }

    //斜率优化
    public static int ways3(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int pre = 1; pre < dp.length; pre++) {
            dp[pre][0] = 1;
            dp[pre][pre] = 1;
        }
        for (int pre = n - 1; pre > 0; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                dp[pre][rest] = dp[pre][rest - pre] + dp[pre + 1][rest];
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int n = 4;
        int i = splitNumber(n);
        int i1 = ways2(n);
        int i2 = ways3(n);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
    }

}
