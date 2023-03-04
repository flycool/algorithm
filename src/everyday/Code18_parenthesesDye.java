package everyday;

/**
 * 18 猿辅导
 * 2022.8.7笔试第三道
 * 给定一个数组ar，和一个正数k
 * 如果arr[i]==0，表示i这里既可以是左括号也可以是右括号,
 * 而且可以涂上1~k每一种颜色
 * 如果arr[i]=0，表示i这里已经确定是左括号,颜色就是arr[i]的值
 * 那么arr整体就可以变成某个括号字符串,并且每个括号字符都带有颜色
 * 返回在括号字符串合法的前提下,有多少种不同的染色方案
 * 不管是排列、还是颜色,括号字符串任何一点不一样,就算不同的染色方案
 * 最后的结果%10001,为了方便,我们不处理mod,就管核心思路
 * 2<=a长度<=5000
 * 1<=k<=1000
 * 0 <= arr [i]<= k
 * (一个合法的括号字符串，有 k^(n-2a)/2  种)
 */
public class Code18_parenthesesDye {

    public int way(int[] arr, int k) {
        int n = arr.length;
        if ((n & 1) != 0) {//奇数
            return 0;
        }
        int a = combines(arr);
        int b = 0;
        for (int num : arr) {
            if (num != 0) {
                b++;
            }
        }
        //一个合法的可能染色数
        double c = Math.pow(k, (n - b << 1) >> 1);
        return (int) (a * c);
    }

    // 忽略染色，求合法的括号的结合数量
    public int combines(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(arr, 0, 0, dp);
    }

    // 在arr[i...]范围上做决定
    // 之前在arr[0..i-1]上的决定，使得左括号比右括号多了j个
    // 最终合法的括号结合是多少
    private int f(int[] arr, int i, int j, int[][] dp) {
        int n = arr.length;
        if (i == n) {
            return j == 0 ? 1 : 0;
        }
        if (j < 0) {
            return 0;
        }
        if (n - i < j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (arr[i] > 0) {
            ans = f(arr, i + 1, j + 1, dp);
        } else {
            //左括号和后括号的可能
            ans = f(arr, i + 1, j + 1, dp) + f(arr, i + 1, j - 1, dp);
        }
        return ans;
    }
}
