package zuo2023;

public class Code09_SomeDPFromVT {

    /**
     * 找到一个最少方案数，让FunnyGoal、OffenseGoal,都大于等于
     * 定义如下尝试过程
     * 贴纸数组stickers
     * stickers[i][O]: i号贴纸的Funny值
     * stickers[i][1]：i号贴纸的offense值
     * index....所有的贴纸，随便选择。index之前的贴纸不能选择，
     * 在让restFunny和restOffense都小于等于O的要求下，返回最少的贴纸数量
     */
    public int minStickers(int[][] arr, int funnyGoal, int offenseGoal) {
        return process(arr, 0, funnyGoal, offenseGoal);
    }

    public int process(int[][] arr, int index, int restFunny, int restOffense) {
        if (restFunny <= 0 && restOffense <= 0) {
            return 0;
        }
        if (index == arr.length) {
            return Integer.MAX_VALUE;
        }
        int p1 = process(arr, index + 1, restFunny, restOffense);
        int p2 = Integer.MAX_VALUE;
        int next = process(arr, index + 1, restFunny - arr[index][0], restOffense - arr[index][1]);
        if (next != Integer.MAX_VALUE) {
            p2 = 1 + next;
        }
        return Math.min(p1, p2);
    }


    /**
     * 绳子总长度为M
     * 每一个长度的绳子对应一个价格，比如(6,10)表示剪成长度为6的绳子，对应价格10
     * 可以重复切出某个长度的绳子
     * 定义递归如下：
     * 所有可以切出来的长度对应价值都在数组ropes.里
     * ropes[i订={6,10}代表i方案为：切出长度为6的绳子，可以卖10元
     * index....所有的方案，随便选择。index之前的方案，不能选择
     * 返回最大的价值
     * 自己去改动态规划
     */
    public int maxValue(int[][] ropes, int index, int resLen) {
        if (resLen <= 0 || index == ropes.length) {
            return 0;
        }
        int p1 = maxValue(ropes, index + 1, resLen);
        int p2 = 0;
        if (ropes[index][0] <= resLen) {
            int next = maxValue(ropes, index, resLen - ropes[index][0]);//可以重复选， index不需加1
            p2 = ropes[index][1] + next;
        }
        return Math.max(p2, p1);
    }


    /**
     * 每一个序列都是[a, b]的形式，a<b
     * 序列连接的方式为，前一个序列的b,要等于后一个序列的a
     * 比如：[3,7]、[7,13]、[13,26]这三个序列就可以依次连接
     * 给定若干个序列，求最大连接的数量
     * 定义尝试过程如下
     * arr[订={4,9}表示，第i个序列4开始，9结束
     * pre:代表选择的上一个序列的index是多少
     * 比如选择的上一个序列如果是(4,9)，是第5个序列，那么 pre=5
     * 特别注意：如果从来没有选过序列，那么 pre=-1
     * 这个函数含义：
     * index....所有的序列，随便选择。index之前的序列，不能选择
     * 上一个选择的序列，是pre号，如果pre==-1,说明之前没有选择过序列
     * 返回题目要求的那种连接方式下，最大的序列数量
     */
    public int maxLen(int[][] arr, int index, int pre) {
        if (index == arr.length) {
            return 0;
        }
        int p1 = maxLen(arr, index + 1, pre);
        int p2 = -1;
        if (pre == -1 || arr[pre][1] == arr[index][0]) {
            p2 = 1 + maxLen(arr, index + 1, index);
        }
        return Math.max(p2, p1);
    }


}

