package everyday;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 37 亚马逊
 * 给定一个数组arr,和一个正数k
 * 你可以随意删除arr中的数字,最多删除k个
 * 目的是让连续出现一种数字的长度尽量长
 * 返回这个尽量长的长度
 * 比如数组arr={3,-2,3,3,5,6,3,-2},k=3
 * 你可以删掉-2、5、6(最多3个),这样数组arr={3,3,3,3,-2}
 * 可以看到连续出现3的长度为4
 * 这是所有删除方法里的最长结果,所以返回4
 * 1<= arr长度 <=3*10^5
 * -10^9<= arr中的数值 <=10^9
 * 0<= k <=3*10^5
 */
public class Code37_removeMostK {

    public int removeMostK(int[] arr, int k) {
        //key: arr的值
        //value: 相同值的下标组成的双端列表
        HashMap<Integer, LinkedList<Integer>> valueIndies = new HashMap<>();
        int n = arr.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            if (!valueIndies.containsKey(value)) {
                valueIndies.put(value, new LinkedList<>());
            }
            LinkedList<Integer> indies = valueIndies.get(value);
            while (!indies.isEmpty() && i - indies.peekFirst() - indies.size() > k) {
                indies.pollFirst();
            }
            indies.addLast(i);
            ans = Math.max(ans, indies.size());
        }
        return ans;
    }
}
