package zuo2025.essential.class22;

public class C02_ReversePairs {

    private final int n = 50001;

    private final int[] help = new int[n];

    // 归并分治
    // https://www.leetcode.com/problems/reverse-pairs/
    // 求反转个数
    public int reversePairs(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return reversePairs(arr, l, m) + reversePairs(arr, m + 1, r) + merge(arr, l, m, r);
    }

    private int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && arr[i] > 2 * arr[j]) {
                j++;
            }
            ans += j - m - 1;
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
