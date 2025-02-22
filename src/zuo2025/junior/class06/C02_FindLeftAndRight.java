package zuo2025.junior.class06;


public class C02_FindLeftAndRight {

    // 在有序数组中找到比某个数大（>= target）的最左边的数的位置
    public int findLeft(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2; // 防止(r + l)溢出
            if (arr[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    // 在有序数组中找到比某个数小（<= target）的最右边的数的位置
    public int findRight(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] <= target) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
