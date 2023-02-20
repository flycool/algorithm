package interview2022;

//48 最长递增子序列长度
public class Code48_SubSequence {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 3, 0, 4, 6, 2, 7};
        int i = longestSubSequence(arr);
        System.out.println(i);
    }

    public static int longestSubSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        //end 代表目前所有长度为的递增子序列最小结尾
        int[] end = new int[n];
        end[0] = arr[0];

        int ans = 1;
        int l = 0, r = 0; // l，r为end数组的有效区域
        int m = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            l = 0;
            r = right;
            while (l <= r) { // 二分法，获取 <=arr[i] 的最右位置
                m = (l + r) / 2;
                if (arr[i] > end[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            end[l] = arr[i];
            ans = Math.max(ans, l + 1);
        }
        return ans;
    }
}
