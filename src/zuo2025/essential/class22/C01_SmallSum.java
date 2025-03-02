package zuo2025.essential.class22;

public class C01_SmallSum {

    private final int n = 10001;

    private final int[] help = new int[n];

    // 归并分治
    // https://www.nowcoder.com/practice/edfe05a1d45c4e4ab251b164f4c891f5
    // 小和问题
    public long smallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(arr, l, m) + smallSum(arr, m + 1, r) + merge(arr, l, m, r);
    }

    private long merge(int[] arr, int l, int m, int r) {
        long ans = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] < arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }

        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        // 下面两个while只会中一个
        // b 结束了
        while (a <= m) {
            help[i++] = arr[a++];
        }
        // a 结束了
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }

        return ans;
    }
}
