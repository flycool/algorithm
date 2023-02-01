package intermediate_promote.class01;

public class Code07_NumTrees {

    //给定一个非负整数n，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
    public static int process(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int left = 0; left < n; left++) {
            int leftWays = process(left);
            int rightWays = process(n - 1 - left);
            res += leftWays * rightWays;
        }
        return res;
    }

    //dp way
    public static int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
