package interview2022;

/**
 * 给定一个数组arr，代表孩子的得分
 * 每个孩子至少一颗糖
 * 如果arr[i]>arr[i-1]，i 的孩子比 i-1 的孩子获得的糖多1颗
 * 或者 arr[i]>arr[i+1]，i 的孩子比 i+1 的孩子获得的糖多1颗
 * 返回糖的数量
 * <p>
 * 补充规则：
 * 相邻孩子的分数一样，糖必须一样
 */
public class Code41_Candy {

    public int candy(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}
