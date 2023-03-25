package Involve;

import java.util.TreeSet;

/**
 * 4.
 * 给定一个非负数组arr,和一个正数m。
 * 返回arr的所有子序列中累加和 %m 之后的最大值。
 * 1)如果arr中每个数字不大，怎么做这道题？
 * 2)如果arr中m的值很小，怎么做这道题？
 * 3)如果arr的长度很短，但是arr每个数字比较大并且m比较大呢？
 */
public class Involve_leetcode04_maxSubArrayModM {

    /**
     * 方法1：
     * dp[i][j] 值为true或false
     * i: 0...arr[i].length-1
     * j: 0...arr中的累加和
     * 表示使用arr[0..i]中的任意数字，能否累加和构成j
     * dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i]] (j-arr[i]>=0)
     * 此方法为O(n*sum)，所以累加和不大的时候用
     */
    public int maxValue1(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; // 第0列为true
        }
        dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - arr[i]];
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= sum; j++) {
            if (dp[n - 1][j]) {
                ans = Math.max(ans, j % m);
            }
        }
        return ans;
    }

    /**
     * 方法2：
     * dp[i][j]
     * i: 0...arr[i].length-1
     * j: 0...m
     * 表示使用arr[0..i]中的任意数字，累加和 %m 能否构成 j
     * dp[i][j] = dp[i-1][j]
     * int cur = arr[i]%m
     * if(j-cur>=0) {
     * dp[i][j] = dp[i][j] | dp[i-1][j-cur]
     * }
     * if(m+j-cur<m){
     * dp[i][j] = dp[i][j] | dp[i-1][m+j-cur]
     * }
     */
    public int maxValue2(int[] arr, int m) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0] % m] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j];
                int cur = arr[i] % m;
                if (j - cur >= 0) {
                    dp[i][j] = dp[i][i] | dp[i - 1][j - cur];
                } else {
                    dp[i][j] = dp[i][i] | dp[i - 1][j - cur + m]; // mod 的数转一圈回来
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (dp[n - 1][i]) {
                ans = i;
            }
        }
        return ans;
    }

    // 方法3: 如果arr的长度很短，但是arr每个数字比较大并且m比较大呢？
    public int maxValue3(int[] arr, int m) {
        if (arr.length == 1) {
            return arr[0] % m;
        }
        int mid = (arr.length - 1) / 2;
        TreeSet<Integer> sortSet1 = new TreeSet<>();
        process(arr, 0, 0, mid, m, sortSet1);
        TreeSet<Integer> sortSet2 = new TreeSet<>();
        process(arr, m + 1, 0, arr.length - 1, m, sortSet1);

        int ans = 0;
        // %m 的数在左右两边寻找
        for (Integer left : sortSet1) {
            // 在 sortSet2 中找到 最近的 <= m-1-left 的值
            ans = Math.max(ans, left + sortSet2.floor(m - 1 - left));
        }
        return ans;
    }

    //在arr[0...index]范围上自由选择，每一种选择的累加和 %m 的结果，添加到 TreeSet （有序表，会自动排序）
    public void process(int[] arr, int index, int sum, int end, int m, TreeSet<Integer> sortSet) {
        if (arr.length == end + 1) {
            sortSet.add(sum % m);
        } else {
            process(arr, index + 1, sum, end, m, sortSet);
            process(arr, index + 1, sum + arr[index], end, m, sortSet);

        }
    }

}
