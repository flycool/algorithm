package intermediate_promote.class08;

public class Code02_MinCoins {

    /**
     * 初始人气值为start，要达到人气值刚好为end。
     * 增加人气的方式有：
     * 点赞 花费 x C币 人气 +2
     * 送礼 花费 y C币 人气 *2
     * 私聊 花费 z C币 人气 -2
     * 求最少要花费多少C币刚好到达end人气
     * 找限制条件
     */
    public static int minCoins(int start, int end, int add, int times, int del) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        return process(0, end, start, add, times, del, end * 2, ((end - start) / 2) * add);
    }

    //limitCoin: 一个平凡解
    public static int process(int preMoney, int aim, int cur, int add, int times, int del,
                              int limitAim, int limitCoin) {

        if (preMoney > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (cur < 0) {
            return Integer.MAX_VALUE;
        }
        if (cur > limitAim) {
            return Integer.MAX_VALUE;
        }
        if (cur == aim) {
            return preMoney;
        }
        int min = Integer.MAX_VALUE;
        int p1 = process(preMoney + add, aim, cur + 2, add, times, del, limitAim, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        int p2 = process(preMoney + times, aim, cur * 2, add, times, del, limitAim, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }
        int p3 = process(preMoney + del, aim, cur - 2, add, times, del, limitAim, limitCoin);
        if (p3 != Integer.MAX_VALUE) {
            min = Math.min(min, p3);
        }
        return min;
    }
}
