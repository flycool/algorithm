package leetcode;

//86 leetcode 0340 至多包含k个不同的字符
//滑动窗口
public class Code86_P_0340_KthDiffChar {

    public int longestKthDiffChar(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }
        int n = s.length();
        char[] str = s.toCharArray();
        int[] count = new int[256];
        int diff = 0;
        int r = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && (diff < k && count[str[r]] > 0)) {
                diff += count[str[r]] == 0 ? 1 : 0;
                count[str[r++]]++;
            }
            ans = Math.max(ans, r - i);
            diff -= count[str[i]] == 1 ? 1 : 0;
            count[str[i]]--;
        }
        return ans;
    }
}
