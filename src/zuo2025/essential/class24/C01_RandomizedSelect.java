package zuo2025.essential.class24;

// 无序数组中找到第K大的数
// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class C01_RandomizedSelect {

    // 随机选择算法，时间复杂度 o(n)
    public int findKthLargest(int[] arr, int k) {
        return randomizedSelect(arr, arr.length - k);
    }

    // arr有序，在i位置的值是什么
    public int randomizedSelect(int[] arr, int i) {
        int ans = -1;
        for (int l = 0, r = arr.length - 1; l <= r; ) {
            int x = arr[l + (int) (Math.random() * (r - l + 1))];
            partition(arr, l, r, x);
            if (i < first) {
                r = first - 1;
            } else if (i > last) {
                l = last + 1;
            } else {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }


    // 也是荷兰国旗问题
    private static int first;
    private static int last;

    // <x 放在左边，==x放中间，>x放右边
    private void partition(int[] arr, int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(arr, first++, i++);
            } else if (arr[i] > x) {
                swap(arr, i, last--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
