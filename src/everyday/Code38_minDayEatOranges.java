package everyday;

import java.util.HashMap;

/**
 * 38 腾讯面试
 * 厨房里总共有n个橘子,你决定每一天选择如下方式之一吃这些橘子:
 * 1.吃掉一个橘子。
 * 2.如果剩余橘子数n能被2整除,那么你可以吃掉n/2个橘子。
 * 3.如果剩余橘子数n能被3整除,那么你可以吃掉2*(n/3)个橘子。
 * 每天你只能从以上3种方案中选择一种方案。
 * 请你返回吃掉所有n个橘子的最少天数。
 */
public class Code38_minDayEatOranges {

    public HashMap<Integer, Integer> dp = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        // n=17
        // 1天吃掉1个橘子，1天吃掉8个橘子，+ minDays(8)
        int p1 = n % 2 + 1 + minDays(n / 2);
        int p2 = n % 3 + 1 + minDays(n / 3);
        int ans = Math.min(p1, p2);
        dp.put(n, ans);
        return ans;
    }
}
