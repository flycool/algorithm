package interview2022;

/**
 * 61 一维接雨水问题
 * 给定一个数组，值为柱子的格子高度，
 * 返回接到的雨水的格子数
 *
 * 考虑i位置上方几格水，累加
 * i位置的水 = min( max(0~i-1), max(i+1~n) ) - [i]
 * 如果是负数，为0
 */
public class Code61_TrappingRainWater {

    public int trappingRainWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int leftMax = arr[0];
        int rightMax = arr[n - 1];
        int l = 1, r = n - 2;
        int water = 0;
        while (l <= r) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                water += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return water;
    }
}
