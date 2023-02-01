package intermediate_promote.class07;

import javax.sound.midi.MidiChannel;

public class Code04_SubMaxSequece {

    /**
     * 最长递增子序列问题
     * 子序列可以不用连续
     * <p>
     * 1).dp[i]含义：子序列必须以arr[i]结尾下，子序列最长长度
     * 2).ends[i]：当ends[i]有效时，表示，所有长度为i+1的递增子序列中 最小结尾是什么
     * 遇到arr[i]时，看在ends中能否找到比arr[i]更大的最小值，
     * 有替换之，dp[i]的值为 arr[i]的值在ends中包含自己往前的个数
     * 没有，则扩充ends数组
     * <p>
     * ends[i]构建了单调性，能把动态规划的枚举行为减少
     * ends有效区必有序
     */
    public static int getMaxSubSequece(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] dp = new int[n];
        int[] ends = new int[n];
        dp[0] = 1;
        ends[0] = arr[0];
        int index = 0;//ends的有效值

        for (int i = 1; i < n; i++) {
            int mostIndex = find(arr[i], ends, index);
            if (mostIndex >= 0 && ends[mostIndex] >= arr[i]) {
                ends[mostIndex] = arr[i];
            } else {
                ends[++index] = arr[i];
            }
            dp[i] = index + 1;
        }

        return dp[n - 1];
    }

    // 在ends中，二分查找比value大的最小值
    private static int find(int value, int[] ends, int index) {
        int l = 0;
        int r = index;
        if (value > ends[r]) {
            return -1;
        }
        int mid = 0;
        while (l <= r && r >= 0) {
            mid = (l + r) / 2;
            if (ends[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return mid;

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1, 7, 8};
        int i = getMaxSubSequece(arr);
        System.out.println(i);
    }

}
