package zuo2025.essential.class27_radixsort;

import java.util.Arrays;

// 基数排序
// https://leetcode-cn.com/problems/sort-an-array/
public class C01_RadixSort {

    private final int maxn = 5001;
    private final int BASE = 10;

    public int[] help = new int[maxn];
    public int[] bucket = new int[BASE];

    public int[] sortArray(int[] arr) {
        if (arr.length == 0) return arr;

        int n = arr.length;
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        int max = 0;
        // 把arr转成非负数组，并或取其最大值
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }

        radixSort(arr, n, bits(max));

        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
        return arr;
    }

    private int bits(int num) {
        int ans = 0;
        while (num > 0) {
            ans++;
            num /= BASE;
        }
        return ans;
    }

    // 关键点：前缀数量分区技巧，数字提取某一位技巧
    public void radixSort(int[] arr, int n, int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(bucket, 0);
            // 统计提取出每位数字的词频
            for (int i = 0; i < n; i++) {
                bucket[(arr[i] / offset) % BASE]++;
            }
            for (int j = 1; j < BASE; j++) {
                bucket[j] = bucket[j] + bucket[j - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                help[--bucket[(arr[i] / offset) % BASE]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }
    }
}
