package interview2022;

/**
 * 现在有司机n*2人，调度中心会将所有司机平分给A，B两个区域
 * 第i个司机去A可得收入为income[i][0]
 * 第i个司机去B可得收入为income[i][1]
 * 返回所有调度方案中能使所有司机收入最高的方案，是多少钱
 */
public class Code25_Drive {

    public int maxMoney(int[][] income) {
        int n = income.length;
        if (income == null || n < 2 || (n & 1) != 0) {
            return 0;
        }
        return process(income, 0, n >> 1);
    }

    //rest: a区域剩下的数量
    public int process(int[][] income, int index, int rest) {
        int n = income.length;
        if (index == n) {
            return 0;
        }
        if (n - index == rest) {
            return income[index][0] + process(income, index + 1, rest - 1);
        }
        if (rest == 0) {
            return income[index][1] + process(income, index + 1, rest);
        }
        int p1 =  income[index][0] + process(income, index + 1, rest - 1);
        int p2 =  income[index][1] + process(income, index + 1, rest);
        return Math.max(p1, p2);
    }
}
