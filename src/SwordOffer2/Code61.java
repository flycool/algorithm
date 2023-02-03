package SwordOffer2;

/**
 * 扑克牌中的顺子
 *
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Code61 {

    public boolean isStraight(int[] nums) {
        boolean[] t = new boolean[14];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (t[num]) { // 存在重复数字
                return false;
            }
            t[num] = true;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min <= 4;
    }
}
