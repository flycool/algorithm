package struct.slidewindow;

/**
 * 最小覆盖子串
 * 给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串
 * 如果中不存在涵盖t所有字符的子串，则返回空字符串""。
 * 测试链接：https://leetcode.cn/problems/minimum-window-substring/
 */
public class Code03_MinimumWindowSubstring {

    public String minLen(String target, String str) {
        if (str.length() < target.length()) {
            return "";
        }
        char[] s = str.toCharArray();
        char[] t = target.toCharArray();
        int[] cnt = new int[256];
        for (char c : t) {
            cnt[c]--;
        }
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int l = 0, r = 0, debt = target.length(); r < s.length; r++) {
            // 当前字符进窗口
            if (cnt[s[r]]++ < 0) {
                debt--;
            }
            if (debt == 0) {
                while (cnt[s[l]] > 0) {
                    cnt[s[l++]]--; // 左边窗口右移
                }
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }
}
