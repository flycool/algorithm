package jadvance.class04;

public class Code05_BurstBalloon {

    public static int maxPoit(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int n = arr.length;
        int[] help = new int[n + 2];
        help[0] = 1;
        help[n + 1] = 1;
        //System.arraycopy(arr, 0, help, 1, n);
        for (int i = 0; i < n; i++) {
            help[i + 1] = arr[i];
        }
        return process(help, 1, n);
    }

    //打爆arr[L..R]范围上的所有气球，返回最大分数
    //假设arr[L-1]和arr[R+1]的气球一定没有被打爆
    //尝试方式： 每个位置的气球最后打爆
    private static int process(int[] arr, int L, int R) {
        if (L == R) {//只有一个气球了
            return arr[L - 1] * arr[L] * arr[R + 1];
        }
        //先处理头和尾的气球，即arr[L]和arr[R]
        int max = Math.max(
                process(arr, L + 1, R) + arr[L - 1] * arr[L] * arr[R + 1],
                process(arr, L, R - 1) + arr[L - 1] * arr[R] * arr[R + 1]);
        //处理中间的气球
        for (int i = L + 1; i < R; i++) {
            max = Math.max(max, process(arr, L, i - 1) + process(arr, i + 1, R) + arr[L - 1] * arr[i] * arr[R + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5};
        int i = maxPoit(arr);
        System.out.println(i);
    }
}
