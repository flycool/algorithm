package interview2022;

//返回一个数组中，子数组最大累加和
public class Code23_SubArrayMaxSum {

    public int subArrayMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            max = Math.max(cur, max);
            cur = Math.max(cur, 0);
        }
        return max;
    }

    //dp
    public int subArrayMaxSum2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int pre = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre = Math.max(arr[i], arr[i] + pre);
            max = Math.max(pre, max);
        }
        return max;
    }
}
