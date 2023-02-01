package jadvance.class03;

public class Code02_CommonSubstring {
    /**
     * 给定两个字符串str1和str2，求两个字符串的最长公共子串。
     * 请注意区分子串和子序列的不同，子串是连续的，子序列不是
     * <p>
     * 动态规划空间压缩技巧
     * dp[i][j] : str1以i结尾，str2以j结尾时，的最长公共子串是多长(公共子串也是以i，j结尾)
     * 依赖于dp[i-1][j-1]，即左上角的值
     * 用一个变量从右上角更新每个值
     */
    public static String getCommonSubstring(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int max = 0;
        int end = 0;
        int row = 0;
        int col = n2 - 1;//从右上角开始
        while (row < n1) {
            int i = row;
            int j = col;
            int value = 0;
            while (i < n1 && j < n2) {//右斜线遍历
                if (chs1[i] == chs2[j]) {
                    value++;
                } else {
                    value = 0;
                }
                if (value > max) {
                    max = value;
                    end = i;
                }
                //右斜线遍历
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String str1 = "abcd23435djfi";
        String str2 = "adfed23435dcgfghferf";
        String s = getCommonSubstring(str1, str2);
        System.out.println(s);

    }
}
