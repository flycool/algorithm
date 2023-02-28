package leetcode;

import java.util.Arrays;

/**
 * 101 leetcode 0475 供暖器
 * 有地点数组，和供暖器数组，
 * 供暖器的辐射半径统一
 * 返回最小半径能覆盖所有地点
 */
public class Code101_P_0475_findRadius {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (!best(houses, heaters, i, j)) {
                j++;
            }
            ans = Math.max(ans, Math.abs(houses[i] - heaters[j]));
        }
        return ans;
    }

    private boolean best(int[] houses, int[] heaters, int i, int j) {
        return j == heaters.length - 1
                || Math.abs(heaters[j] - houses[i]) < Math.abs(heaters[j + 1] - houses[i]);
    }
}
