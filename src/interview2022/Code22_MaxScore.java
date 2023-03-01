package interview2022;

/**
 * 给你两个长度分别n和m的整数数组nums和multipliers，其中n>=m
 * 数组下标从1开始计数
 * 初始时，你的分数为0
 * 你需要执行恰好m步操作。在第i步操作中，需要：
 * 选择数组nums开头处或者末尾处的整数x。
 * 你获得 multipliers[i]*x 分，并累加到你的分数中
 * 将x从数组nums中移除
 * 在执行m步操作后，返回最大分数。
 */
public class Code22_MaxScore {

    public int maxScore(int[] nums, int[] multipliers) {
        return process(nums, multipliers, 0, nums.length - 1);
    }

    public int process(int[] a, int[] b, int left, int right) {
        int leftAlready = left;
        int rightAlready = a.length - right - 1;
        int i = leftAlready + rightAlready;
        if (i == b.length) {
            return 0;
        }
        int p1 = a[left] * b[i] + process(a, b, left + 1, right);
        int p2 = a[right] * b[i] + process(a, b, left, right - 1);
        return Math.max(p1, p2);
    }
}
