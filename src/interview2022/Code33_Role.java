package interview2022;

/**
 * 给定一个有序数组arr，代表坐落在x轴上的点
 * 给定一个正数k，代表绳子的长度
 * 返回绳子最多压中几个点？
 * 即使绳子边缘处盖住点也算盖住
 */
public class Code33_Role {

    //绳子左端压到点上，窗口向右移动
    public int maxPoint(int[] arr, int k) {
        int l = 0, r = 0;
        int n = arr.length;
        int max = 0;
        while (l < n) {
            while (r < n && arr[r] - arr[l] <= k) {
                r++;
            }
            max = Math.max(max, r - l);
            l++;
        }
        return max;
    }
}
