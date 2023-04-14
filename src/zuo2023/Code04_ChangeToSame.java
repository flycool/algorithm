package zuo2023;

/**
 * 小团生日收到妈妈送的两个一模一样的数列作为礼物！
 * 他很开心的把玩，不过不小心没拿稳将数列摔坏了！
 * 现在他手上的两个数列分别为A和B,长度分别为n和m。
 * 小团很想再次让这两个数列变得一样。他现在能做两种操作：
 * 操作一: 是将一个选定数列中的某一个数a改成数b,这会花费 |b-a| 的时间，
 * 操作二: 是选择一个数列中某个数a,将它从数列中丢掉，花费 |a| 的时间。
 * 小团想知道，他最少能以多少时间将这两个数列变得再次相同！
 * 输入描述：
 * 第一行两个空格隔开的正整数n和m,分别表示数列A和B的长度。
 * 接下来一行n个整数，分别为 A1 A2…An
 * 接下来一行m个整数，分别为 B1 B2…Bm
 * 对于所有数据，1≤n,m≤2000,|Ai|,|Bi| ≤ 10000
 * 输出一行一个整数，表示最少花费时间，来使得两个数列相同。
 */
public class Code04_ChangeToSame {

    public int minCost(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return change(a, b, n, m, dp);
    }

    public int change(int[] a, int[] b, int ai, int bi) {
        if (ai == a.length && bi == b.length) {
            return 0;
        }
        if (ai != a.length && bi == b.length) {
            return a[ai] + change(a, b, ai + 1, bi);
        }
        if (bi != b.length && ai == a.length) {
            return b[bi] + change(a, b, ai, bi + 1);
        }
        int p1 = a[ai] + change(a, b, ai + 1, bi);
        int p2 = b[bi] + change(a, b, ai, bi + 1);
        int p3 = Math.abs(a[ai] - b[bi]) + change(a, b, ai + 1, bi + 1);
        return Math.min(p1, Math.min(p2, p3));
    }

    public int change(int[] a, int[] b, int ai, int bi, int[][] dp) {
        if (ai == a.length && bi == b.length) {
            return 0;
        }
        if (dp[ai][bi] != -1) {
            return dp[ai][bi];
        }
        int ans = 0;
        if (ai != a.length && bi == b.length) {
            ans = a[ai] + change(a, b, ai + 1, bi);
        }
        if (bi != b.length && ai == a.length) {
            ans = b[bi] + change(a, b, ai, bi + 1);
        }
        int p1 = a[ai] + change(a, b, ai + 1, bi);
        int p2 = b[bi] + change(a, b, ai, bi + 1);
        int p3 = Math.abs(a[ai] - b[bi]) + change(a, b, ai + 1, bi + 1);
        ans = Math.min(p1, Math.min(p2, p3));
        return ans;
    }
}
