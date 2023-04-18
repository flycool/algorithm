package zuo2023;

/**
 * 你将得到一个整数数组 matchsticks,其中 matchsticks[i] 是第i个火柴棒的长度。
 * 你要用所有的火柴棍拼成一个正方形
 * 你不能折断任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须使用一次。
 * 如果你能拼出正方形，则返回true,否则返回false。
 * 测试链接：https://leetcode.cn/problems/matchsticks-to-square/
 */
public class Code17_MakeSquare {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if ((sum % 4) != 0) {
            return false;
        }
        int len = sum / 4;
        int[] dp = new int[1 << matchsticks.length];
        return process(matchsticks, 0, 0, len, 4, dp);
    }

    //status: 火柴使用的状态
    public boolean process(int[] arr, int status, long sum, long len, int edges, int[] dp) {
        if (edges == 0) {
            int s = 1 << arr.length - 1;
            return status == s;
        }
        if (dp[status] != 0) {
            return dp[status] == 1;
        }
        boolean ans = false;
        for (int i = 0; i < arr.length; i++) {
            int s = 1 << i;
            if ((status & s) == 0) {//第i个转态没使用
                if ((sum + arr[i]) <= len) {
                    if ((sum + arr[i]) < len) {
                        ans = process(arr, status | (1 << i), sum + arr[i], len, edges, dp);
                    } else {
                        ans = process(arr, status | (1 << i), 0, len, edges - 1, dp);
                    }
                }
            }
            if (ans) {
                break;
            }
        }
        dp[status] = ans ? 1 : -1;
        return ans;
    }
}
