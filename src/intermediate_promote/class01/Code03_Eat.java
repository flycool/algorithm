package intermediate_promote.class01;

public class Code03_Eat {

    //有N份草，只能吃4的幂次方份草，先手先吃，后手后吃，谁吃完最后谁赢，求谁赢
    public static String winner(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        int base = 1;
        while (base <= n) {
            if (winner(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) {//防止base*4溢出
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    //打表法
    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }

}
