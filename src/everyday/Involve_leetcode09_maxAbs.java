package everyday;

/**
 * 9.
 * 给定一个数组arr,要求把arr分割成左右两半，
 * 分割方法当然很多，但是每一种分割都可能让下列值发生变化：
 * S=绝对值（左部分的最大值-右部分的最大值）
 * 返回S尽可能大的值
 */
public class Involve_leetcode09_maxAbs {

    public int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int max = 0;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        int p1 = max - arr[0];
        int p2 = max - arr[n-1];
        return Math.max(p1, p2);
    }
}
