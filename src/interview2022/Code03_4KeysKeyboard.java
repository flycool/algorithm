package interview2022;

// https://leetcode.com/problems/4-keys-keyboard/
public class Code03_4KeysKeyboard {

    public int maxA(int n) {
        int[] dp = new int[n];
        //连续5次粘贴，一定不是最优解
        for (int i = 0; i < 6 && i < n; i++) {
            dp[i] = i + 1;
        }
        for (int i = 6; i < n; i++) {
            dp[i] = Math.max(
                    Math.max(dp[i - 3] * 2, dp[i - 4] * 3),
                    Math.max(dp[i - 5] * 4, dp[i - 6] * 5)
            );
        }
        return dp[n - 1];
    }
}
