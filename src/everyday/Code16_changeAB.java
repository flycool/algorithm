package everyday;

/**
 * 16 来自美团8.20笔试
 * 小团手上的两个数列分别为A和B，长度分别为n和m。
 * 小团很想再次让这两个数列变得一样。他现在能做两种操作:
 * 操作一是将一个选定数列中的某一个数a改成数b，这会花费lb-al的时间
 * 操作二是选择一个数列中某个数a，将它从数列中丢掉，花费lal的时间
 * 小团想知道，他最少能以多少时间将这两个数列变得再次相同!
 *
 * 对于所有数据，1≤n，m≤2000，|Ail，lBi|≤10000
 * 输出一行一个整数,表示最少花费时间,来使得两个数列相同
 */
public class Code16_changeAB {

    public int change(int[] a, int[] b, int ai, int bi) {
        if (a.length == 0 && b.length == 0) {
            return 0;
        }
        if (ai == a.length && bi != b.length) {
            return b[bi] + change(a, b, ai, bi + 1);
        }
        if (ai != a.length && bi == b.length) {
            return a[ai] + change(a, b, ai + 1, bi);
        }
        int p1 = a[ai] + change(a, b, ai + 1, bi);
        int p2 = b[bi] + change(a, b, ai, bi + 1);
        int p45 = Math.abs(a[ai] - b[bi]) + change(a, b, ai + 1, bi + 1);
        return Math.min(Math.min(p1, p2), p45);
    }

    //dp 缓存
    public int change(int[] a, int[] b, int ai, int bi, int[][] dp) {
        if (a.length == 0 && b.length == 0) {
            return 0;
        }
        if (dp[ai][bi] != -1) {
            return dp[ai][bi];
        }
        int ans = 0;
        if (ai == a.length && bi != b.length) {
            ans = b[bi] + change(a, b, ai, bi + 1);
        } else if (ai != a.length && bi == b.length) {
            ans = a[ai] + change(a, b, ai + 1, bi);
        } else {
            int p1 = a[ai] + change(a, b, ai + 1, bi);
            int p2 = b[bi] + change(a, b, ai, bi + 1);
            int p45 = Math.abs(a[ai] - b[bi]) + change(a, b, ai + 1, bi + 1);
            ans = Math.min(Math.min(p1, p2), p45);
        }
        dp[ai][bi] = ans;
        return ans;
    }

}
