package everyday;

import java.util.HashMap;

/**
 * 13. 给定一个数组arr，和整数sum
 * 返回累加和等于sum的子数组有多少个
 */
public class Involve13_SubArraySumEqualsK {

    public int subArraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //key: 前缀和，value: 出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int all = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            all += arr[i];
            if (!map.containsKey(all)) {
                map.put(all, 1);
            } else {
                map.put(all, map.get(all) + 1);
            }
            if (map.containsKey(all - k)) {
                ans += map.get(all - k);
            }
        }
        return ans;
    }
}
