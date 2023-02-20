package interview2022;

/**
 * 44 编辑距离问题
 * 求str1到str2的编辑距离
 * 编辑代价：
 * 保留，删除，增加，替换
 * (根据结尾划分可能性)
 */
public class Code44_EditDistance {

    public int minDistance(String s1, String s2, int insert, int delete, int replace) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int n = str1.length + 1;
        int m = str2.length + 1;
        int[][] dp = new int[n][m];
        for (int i = 1; i < n; i++) {
            dp[i][0] = delete * i;
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = insert * j;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //四种可能 考虑最后一位的情况
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + replace;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + delete); //j 多一个
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + insert); //j 少一个
            }
        }
        return dp[n - 1][m - 1];
    }
}
