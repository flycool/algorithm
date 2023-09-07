package everyday;

/**
 * 56 来自华为OD
 * 完美走位问题
 * 给定一个由'Q'、'W'、'E'、'R'四种字符组成的字符串，长度一定是4的倍数
 * 你可以把任意连续的一段子串，变成'Q'、'W、E'、'R'组成的随意状态
 * 目的是让4种字符词频一样
 * 返回需要修改的最短子串长度
 * 测试链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 */
public class Code56_ReplaceTheSubstringForBalanceString {

    public int balanceString(String str) {
        int n = str.length();
        int[] arr = new int[n];
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            arr[i] = c == 'W' ? 1 : (c == 'E' ? 2 : (c == 'R' ? 3 : 0));
            cnt[arr[i]]++;
        }
        int ans = n;
        for (int l = 0, r = 0; l < n; l++) {
            while (!ok(cnt, l, r) && r < n) {
                cnt[arr[r++]]--;
            }
            if (ok(cnt, l, r)) {
                ans = Math.max(ans, r - l);
            } else {
                break;
            }
            cnt[arr[l]]++;
        }
        return ans;
    }

    public boolean ok(int[] cnt, int l, int r) {
        int maxCnt = Math.max(Math.max(cnt[0], cnt[1]), Math.max(cnt[2], cnt[3]));
        int changes = maxCnt * 4 - cnt[0] - cnt[1] - cnt[2] - cnt[3];
        int rest = r - l - changes; // 一位对应一次change
        return rest >= 0 && rest % 4 == 0;
    }
}