package interview2022;

/**
 * 一开始有21个球，甲和乙轮流拿球，甲先，乙后
 * 每个人在自己的回合，一定要拿不超过3个球，不能不拿
 * 最终谁的总球数为偶数，谁赢
 * 请问谁有必胜的策略
 * （打表法）
 */
public class Code19_WhoWin21Balls {

    public String whoWin(int balls) {
        return process(0, balls, 0, 0);
    }

    public String process(int turn, int rest, int jia, int yi) {
        if (rest == 0) {
            return jia % 2 == 0 ? "甲" : "乙";
        }
        if (turn == 0) { //甲回合
            for (int pick = 1; pick <= Math.min(3, rest); pick++) {
                String next = process(1, rest - pick, jia + pick, yi);
                if (next.equals("甲")) {
                    return "甲";
                }
            }
            return "乙";
        } else {
            for (int pick = 1; pick <= Math.min(3, rest); pick++) {
                String next = process(0, rest - pick, jia, yi + pick);
                if (next.equals("乙")) {
                    return "乙";
                }
            }
            return "甲";
        }
    }
}
