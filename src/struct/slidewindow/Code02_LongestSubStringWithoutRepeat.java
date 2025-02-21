package struct.slidewindow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2.
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 测试链接：https://leetcode.cn/problems/Longest-substring-without-repeating-characters/
 */
public class Code02_LongestSubStringWithoutRepeat {

    public int longestSubString(String str) {
        char[] s = str.toCharArray();
        int n = str.length();
        // 上次字符出现的位置
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            l = Math.max(l, last[s[r]] + 1);
            ans = Math.max(ans, r - l + 1);
            last[s[r]] = r; // 更新上次出现字符的位置
        }
        return ans;
    }

}
