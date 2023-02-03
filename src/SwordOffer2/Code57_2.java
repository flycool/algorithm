package SwordOffer2;

import java.util.ArrayList;

/**
 * 和为 s 的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Code57_2 {

    //双指针
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int l = 1, r = 2;
        while (l < r) {
            int s = (l + r) * (r - l + 1) >> 1;//等差数列求值
            if (s == target) {
                int[] t = new int[r - l + 1];
                for (int i = 0; i < t.length; i++) {
                    t[i] = l + i;
                }
                list.add(t);
                ++l;
            } else if (s < target) {
                ++r;
            } else {
                ++l;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
