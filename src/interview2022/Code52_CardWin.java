package interview2022;

/**
 * 52.抽牌获胜概率问题
 * 面值为1-n的牌组成一组
 * 每次你从组里等概率的抽出1~n中的一张
 * 下次抽会换一个新的组，有无限组
 * 当累加和<a时，你将一直抽牌
 * 当累加和>=a和<b时，你将获胜
 * 当累加和>=b时，你将失败
 * 返回获胜的概率，给定的参数为n，a，b
 */
public class Code52_CardWin {

    public double cardWin() {
        return p1(0);
    }

    public double p1(int cur) {
        if (cur >= 17 && cur < 21) {
            return 1.0;
        }
        if (cur >= 21) {
            return 0.0;
        }
        double w = 0.0;
        for (int i = 1; i <= 10; i++) {
            w += p1(cur + i);
        }
        return w / 10;
    }

    public double p2(int cur, int n, int a, int b) {
        if (cur >= a && cur < b) {
            return 1.0;
        }
        if (cur >= a) {
            return 0.0;
        }
        double w = 0.0;
        for (int i = 1; i <= n; i++) {
            w += p2(cur + i, n, a, b);
        }
        return w / n;
    }

    //优化
    public double p3(int cur, int n, int a, int b) {
        if (cur >= a && cur < b) {
            return 1.0;
        }
        if (cur >= a) {
            return 0.0;
        }
        if (cur == a - 1) {
            return 1.0 * (b - 1) / n;
        }
        double w = p3(cur + 1, n, a, b) + p3(cur + 1, n, a, b) * n;
        if (cur + 1 + n < b) {
            w -= p3(cur + 1 + n, n, a, b);
        }
        return w / n;
    }

    public double f(int n, int a, int b) {
        if (n < 1 || a >= b || a < 0 || b < 0) {
            return 0.0;
        }
        if (b - a >= n) {
            return 1.0;
        }
        double[] dp = new double[b];
        for (int i = a; i < b; i++) {
            dp[i] = 1.0;
        }
        if (a - 1 >= 0) {
            dp[a - 1] = 1.0 * (b - a) * n;
        }
        for (int cur = a - 2; cur >= 0; cur--) {
            double w = dp[cur + 1] + dp[cur + 1] * n;
            if (cur + 1 + n < b) {
                w -= dp[cur + 1 + n];
            }
            dp[cur] = w / n;
        }
        return dp[0];
    }


}