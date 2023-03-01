package interview2022;

//求一个字符串中，最长无重复字符子串长度
public class Code38_LongestSubString {

    public int longestSubString(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        char[] str = s.toCharArray();
        //字符上次出现的位置
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        map[str[0]] = 0;//0位置的字符记录在0位置
        int ans = 1;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            int p1 = i - map[str[i]];
            int p2 = pre + 1;
            int cur = Math.min(p1, p2);
            ans = Math.max(ans, cur);
            pre = cur;
            map[str[i]] = i;
        }
        return ans;
    }
}
