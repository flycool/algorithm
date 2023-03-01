package interview2022;

/**
 * 给定一个数组arr，你可以在每个数字之前决定+或者-
 * 但是必须所有数字都参与
 * 再给定一个数target，
 * 请问最后算出target的方法数是多少
 */
public class Code35_TargetSumWay {

    public int findTargetSumWays(int[] arr, int s) {
        return process(arr, 0, s);
    }

    //暴力递归
    public int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        return process(arr, index + 1, rest - arr[index]) + process(arr, index + 1, rest + arr[index]);
    }


    //p = (sum + target) / 2
    public int findTargetSumWays2(int[] arr, int target) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum < target || ((target & 1) ^ (sum & 1)) != 0) {
            return 0;
        }
        return subset(arr, (sum + target) >> 1);
    }

    //动态规划的空间压缩
    private int subset(int[] arr, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : arr) {
            for (int i = s; i >= n ; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

}
