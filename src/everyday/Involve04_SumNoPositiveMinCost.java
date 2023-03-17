package everyday;

import java.util.Arrays;

/**
 * 4. 微软
 * 给定一个正数数组arr长度为n、正数x、正数y
 * 你的目标是让arr整体的累加和<=0
 * 你可以对数组中的数num执行以下三种操作中的一种,且每个数最多能执行一次操作:
 * 1)不变
 * 2)可以选择让num变成0,承担x的代价
 * 3)可以选择让num变成-num,承担y的代价
 * 返回你达到目标的最小代价
 * 数据规模:面试时面试官没有说数据规模
 */
public class Involve04_SumNoPositiveMinCost {

    public int minCost(int[] arr, int x, int y) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int l = 0, r = n - 1; l <= r; l++, r--) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        if (x >= y) { //没必要使用x的代价了
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            int cost = 0;
            for (int i = 0; i < n && sum > 0; i++) {
                sum -= arr[i] << 1;
                cost += y;
            }
            return cost;
        } else {
            int benefit = 0;
            int cost = arr.length * x;
            int rightSum = 0;
            for (int l = 0, r = n; l < r - 1; l++) {
                benefit += arr[l];
                while (r - 1 > l && (rightSum += arr[r - 1]) <= benefit) {
                    r--;
                }
                int curCost = (l + 1) * y + (r - l - 1) * x;
                cost = Math.min(cost, curCost);
            }
            return cost;
        }
    }
}
