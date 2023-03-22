package everyday;

/**
 * 8.
 * 给定一个只由字符G和R组成的字符串str,
 * 你的目标达成以下哪个都行：
 * 1,让str整体都变成G或者R
 * 2,让左部分都变成R并且右部分都变成G
 * 返回最少需要改变几个字符的值能达成目标
 */
public class Involve_leetcode08_ColorLeftRight {

    public int minPaint(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int n = s.length();
        int rAll = 0; // 右边 R  的总数量
        for (int i = 0; i < n; i++) {
            rAll += str[i] == 'R' ? 1 : 0;
        }
        int ans = rAll;
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            left += str[i] == 'G' ? 1 : 0;
            rAll -= str[i] == 'R' ? 1 : 0;
            ans = Math.min(ans, left + rAll);
        }
        ans = Math.min(ans, left + (str[n - 1] == 'G' ? 1 : 0));
        return ans;
    }

}
