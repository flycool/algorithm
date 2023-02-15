package interview2022;

import java.util.Arrays;

/**
 * 给定一个正数数组arr，代表若干人的体重
 * 再给定一个正数limit，表示所有船共同拥有的载重量
 * 每艘船最多坐两人，且不能超过载重
 * 想让所有的人同时过河，并且用最好的分配方法让船尽量少
 * 返回最少的船数
 */
public class Code22_MinBoat {

    public int minBoat(int[] arr, int limit) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        Arrays.sort(arr);
        if (arr[n - 1] > limit) {
            return -1;
        }
        int lessR = -1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] <= limit / 2) {
                lessR = i;
                break;
            }
        }



        return 0;
    }
}
