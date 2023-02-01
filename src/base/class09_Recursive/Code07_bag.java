package base.class09_Recursive;

/**
 * weight[i], values[i] 分别代表i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重的袋子，你装的物品不能超过该重量。
 * 返回你能装下最多的价值是多少？
 */
public class Code07_bag {

    //i...之后的货物自由选择，形成最大价值返回
    //重量不要超过bag
    public static int process(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(process(weights, values, i + 1, alreadyWeight, bag),
                values[i] + process(weights, values, i + 1, alreadyWeight + weights[i], bag));

    }
}
