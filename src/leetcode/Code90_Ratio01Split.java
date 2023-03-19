package leetcode;

import java.util.HashMap;

/**
 * 90 前缀01串切成等比例的最大部分数
 * 把一个01字符串切成多个部分，要求每一部分的0和1比例一样
 * 同时要求尽可能多的划分
 * 返回结果数组
 * （前缀有多少个比例相同的，再加上自己，就是划分数）
 */
public class Code90_Ratio01Split {

    public int[] split(int[] arr) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int n = arr.length;
        int[] ans = new int[n];
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zero++;
            } else {
                one++;
            }
            if (zero == 0 || one == 0) {
                ans[i] = i + 1;
            } else { //0和1都有
                int gcd = gcd(zero, one);
                // zero = 10 , one = 20
                // a = 10/10, b = 20/10
                int a = zero / gcd;
                int b = one / gcd;
                // a/b 比例，之前有多少前缀拥有
                if (!map.containsKey(a)) { // 分子
                    map.put(a, new HashMap<>());
                }
                if (!map.get(a).containsKey(b)) { //有这个分母
                    map.get(a).put(b, 1);
                } else {
                    //把ans提前+1，直接取出就是答案
                    map.get(a).put(b, map.get(a).get(b) + 1);
                }
                ans[i] = map.get(a).get(b);
            }
        }
        return ans;
    }

    //最大公约数
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int gcd2(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
