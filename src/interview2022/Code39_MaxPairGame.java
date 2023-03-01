package interview2022;

import java.util.Arrays;

/**
 * 给定一个数组arr，代表每个人的能力值
 * 再给定一个非负数k
 * 如果两个人能力差值正好是k，那么可以凑在一起比赛
 * 一局比赛只有两个人
 * 返回最多可以同时又多少场比赛
 */
public class Code39_MaxPairGame {

    //窗口
    public int maxPairGame(int[] arr, int k) {
        if (k < 0 || arr == null || arr.length < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        int l = 0, r = 0;
        boolean[] used = new boolean[n];
        while (l < n && r < n) {
            if (used[l]) {
                l++;
            } else if (l >= r) {
                r++;
            } else {
                int len = arr[r] - arr[l];
                if (len == k) {
                    ans++;
                    used[r++] = true;
                    l++;
                } else if (len > k) {
                    l++;
                } else {
                    r++;
                }
            }
        }
        return ans;
    }
}
