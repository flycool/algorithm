package everyday;

/**
 * 9. 哈喽单车
 * 给定一个总和X，先手和后手依次拿走分数，谁最先拿完谁赢
 * 但是每一轮只能拿走平方数：1，4，9，16，25，36...
 * 根据输入的X，返回先手会不会必胜
 * 先手和后手都绝对理性，博弈论的设定
 */
public class Involve09_PointWin {

    //  当前那分数的人，面对x这个分数，最终会不会赢
    public boolean win(int x) {
        if (x == 0) {
            return false;
        }
        for (int i = 1; i * i <= x; i++) {
            int curValue = i * i;
            int rest = x - curValue;
            if (!win(rest)) {
                return true;
            }
        }
        return false;
    }

    public boolean win2(int n) {
        //dp 为 上面win(x)的返回值
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
