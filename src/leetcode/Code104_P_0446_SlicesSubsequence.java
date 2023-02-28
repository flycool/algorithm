package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

//104 leetcode 0446 等差数列划分ii-子序列
public class Code104_P_0446_SlicesSubsequence {

    public int numOfArithmeticsSlices(int[] arr) {
        int n = arr.length;
        ArrayList<HashMap<Integer, Integer>> maps = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            maps.add(new HashMap<>());
            for (int j = i-1; j >= 0; j--) {
                long diff = (long) arr[i] - (long) arr[j];
                if (diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE) {
                    continue;
                }
                int dif = (int) diff;
                int count = maps.get(j).getOrDefault(dif, 0);
                ans += count;
                maps.get(i).put(dif, maps.get(i).getOrDefault(dif, 0) + count + 1);
            }
        }
        return ans;
    }
}
