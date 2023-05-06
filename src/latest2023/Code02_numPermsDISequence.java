package latest2023;

/**
 * 02 来自亚马逊
 * 给定一个长度为n的字符串s,其中s[i]是：
 * D 意味着减少
 * I 意味着增加
 * 有效排列 是对有 n+1 个在[O,n]范围内的整数的一个排列perm,使得对所有的i:
 * 如果s[i]=='D',那么perm[i]>perm[i+1],以及；
 * 如果s[i]=='I',那么perm[i]<perm[i+1]。
 * 返回有效排列perm的数量。因为答案可能很大，所以请返回你的答案对 10^9+7 取余。
 * 测试链接：
 * https://leetcode.cn/problems/valid-permutations-for-di-sequence
 */
public class Code02_numPermsDISequence {

    public int numPermsDISequence(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        return ways(str, 0, n + 1, n + 1);
    }

    /**
     * @param i 已经用了几个数
     * @param less 比前一个数小的数字有几个
     * @return 后续满足str关系的排列，有几个
     */
    public int ways(char[] s, int i, int less, int n) {
        int ans = 0;
        if (i == n) {
            ans = 1;
        } else if (i == 0 || s[i - 1] == 'D') {
            for (int nextLess = 0; nextLess < less; nextLess++) {
                ans += ways(s, i + 1, nextLess, n);
            }
        } else {
            for (int nextLess = less; nextLess < n - i; nextLess++) {
                ans += ways(s, i + 1, nextLess, n);
            }
        }
        return ans;
    }
}
