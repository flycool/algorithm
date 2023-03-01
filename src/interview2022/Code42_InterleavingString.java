package interview2022;

/**
 * 字符串交错组成
 * 两个字符串的顺序不变
 * （样本对应模型）
 */
public class Code42_InterleavingString {

    public boolean interleavingString(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] total = s3.toCharArray();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (str1[i - 1] != total[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= len2; j++) {
            if (str2[j - 1] != total[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1] == total[i + j - 1] && dp[i - 1][j]
                        || str1[j - 1] == total[i + j - 1] && dp[i][j - 1]
                ) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[len1][len2];
    }
}
