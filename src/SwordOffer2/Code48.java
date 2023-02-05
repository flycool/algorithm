package SwordOffer2;

import java.util.HashSet;

/**
 * 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Code48 {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, j = 0;
        HashSet<Character> vis = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (vis.contains(s.charAt(i))) {//直到 s[i] 不在哈希表 vis 中为止
                vis.remove(s.charAt(j++));
            }
            vis.add(s.charAt(i));
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
