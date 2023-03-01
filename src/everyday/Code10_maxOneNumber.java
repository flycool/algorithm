package everyday;

/**
 * 10. 小红书
 * 数组里有0和1，一定要翻转一个区间，翻转：0变1，1变0
 * 请问翻转后可以使得1的个数最多是多少？
 * （子数组最大累加和问题）
 */
public class Code10_maxOneNumber {

    public int maxOneNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int num : arr) {
            ans += num;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : -1;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = Math.max(cur, 0);
        }
        return ans + max;
    }
}
