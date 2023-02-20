package interview2022;

/**
 * 46 随意选两根支柱所能容纳的最大水量
 * 双指针
 */
public class Code46_RainContainer {

    public int maxRainContainer(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            int p = Math.min(arr[l], arr[r]) * (r - l);  // 取较小的支柱，来获得面积
            ans = Math.max(ans, p);
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
