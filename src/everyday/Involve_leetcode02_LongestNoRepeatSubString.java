package everyday;

/**
 * 2.
 * 给定一个只由小写字母组成的字符串str，
 * 返回其中最长无重复字符串的子串长度
 */
public class Involve_leetcode02_LongestNoRepeatSubString {

    public int maxLen(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int n = s.length();
        // last[0]-->a字母上次出现的位置
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        last[str[0] - 'a'] = 0;
        int max = 1;
        int preMaxLen = 1;
        for (int i = 1; i < n; i++) {
            preMaxLen = Math.min(i - last[str[i] - 'a'], preMaxLen + 1);
            max = Math.max(max, preMaxLen);
            last[str[i] - 'a'] = i;
        }
        return max;
    }
}
