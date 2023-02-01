package jadvance.class01;

import java.util.HashMap;

public class Code02_MostEOR {

    /**
     * 给出n个数字 a_1....a_n，问最多有多少不重叠的非空区间，
     * 使得每个区间内数字的xor都等于0。
     * 假设答案法
     */
    public static int mostEOR(int[] arr) {
        int n = arr.length;
        int xor = 0;
        //dp[i]: 以i结尾在最优划分的情况下，异或和为0最多的部分是多少个
        int[] dp = new int[n];
        //key: 从0出发的某个前缀异或和
        //value: 这个前缀异或和出现的最晚位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                //0...pre--->pre+1...i 最优划分，最后一个部分
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor, i);
        }
        return dp[n - 1];

    }
}
