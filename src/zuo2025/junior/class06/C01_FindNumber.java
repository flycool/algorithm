package zuo2025.junior.class06;

// 在有序数组中找到某个数是否存在
public class C01_FindNumber {

    // arr 保证有序, 二分查找
    public boolean findNumber(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = l + (r - l) / 2; // 防止(r + l)溢出
            if (arr[m] == target) {
                return true;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
