package interview2022;

/**
 * 65 最小包含子串
 * 给定两个字符串str1和str2
 * 在str1中寻找一个最短子串，能包含str2的所有字符
 * 字符顺序无所谓，str1的这个最短子串也可以包含多余的字符
 * 返回这个最短包含子串
 * （窗口）
 */
public class Code65_MinSubString {

    public int minSubStringLength(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < str2.length; i++) {
            map[str2[i]]++;
        }
        int all = str2.length;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        while (r != str1.length) {
            map[str1[r]]--;
            if (map[str1[r]] >= 0) {
                all--;
            }
            if (all == 0) {//还完了
                while (map[str1[l]] < 0) {
                    map[str1[l]]++;
                    l++;
                }
                minLen = Math.min(minLen, r - l + 1);
                all++;
                map[str1[l++]]++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
