package everyday;

/**
 * 58 来自亚马逊、苹果
 * 你有一个凸的n边形，其每个顶点都有一个整数值。给定一个整数数组values,
 * 其中values[i]是第i个顶点的值（即顺时针顺序）。
 * 假设将多边形剖分为n-2个三角形。
 * 对于每个三角形，该三角形的值是顶点标记的乘积，
 * 三角剖分的分数是进行三角剖分后所有n-2个三角形的值之和。
 * 返回多边形进行三角剖分后可以得到的最低分。
 * 测试链接：https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/
 */
public class Code58_MinScoreTriangulationPolygon {

    public int minScore(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        return f(arr, 0, arr.length - 1);
    }

    private int f(int[] arr, int l, int r) {
        if (l > r - 2) {
            return 0;
        }
        if (l == r - 2) {
            return arr[l] * arr[l + 1] * arr[r];
        }
        int ans = Integer.MAX_VALUE;
        for (int m = l + 1; m < r; m++) {
            int left = f(arr, l, m);
            int mid = arr[l] * arr[m] * arr[r];
            int right = f(arr, m, r);
            ans = Math.min(ans, left + mid + right);
        }
        return ans;
    }

    public int minScore2(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(arr, 0, arr.length - 1, dp);
    }

    private int f2(int[] arr, int i, int j, int[][] dp) {
        if (i > j - 2) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int m = i + 1; m < j; m++) {
            int left = f2(arr, i, m, dp);
            int mid = arr[i] * arr[m] * arr[j];
            int right = f2(arr, m, j, dp);
            ans = Math.min(ans, left + mid + right);
        }
        dp[i][j] = ans;
        return ans;
    }

}
