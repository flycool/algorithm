package latest2023;

import java.util.PriorityQueue;

/**
 * 03 来自学员问题，来自真实笔试
 * 景区里有m个项目，也就是项目数组为 int[][] game,这是一个m*2的二维数组
 * 景区的第个项目有如下两个参数：
 * game[i]={Ki,Bi}
 * Ki一定是负数，Bi一定是正数
 *
 * 举个例子：
 * Ki=-2,Bi=10
 * 如果只有1个人买票，单张门票的价格为：Ki*1+Bi=8
 * 所以这1个人游玩该项目要花8元
 * 如果有2个人买票，单张门票的价格为：Ki*2+Bi=6
 * 所以这2个人游玩该项目要花6*2=12元
 * 如果有5个人买票，单张门票的价格为：Ki*2+Bi=0
 * 所以这5个人游玩该项目要花0*5=0元
 * 如果有更多人买票，都认为花0元（因为你让项目倒贴钱实在是太操蛋了）
 * 于是可以认为，如果有x个人买票，单张门票的价格为：Ki*X+Bi
 * x个人游玩这个项目的总花费是：max{(Ki*x+Bi)*X,0}
 * 你作为领导，单位一共有 n 个人，每个人最多可以选1个项目来游玩，也可以不选任何项目
 * 所有员工将在明晚提交选择，然后由你去按照上面的规则，统一花钱，统一购票
 * 求要准备至少多少钱，才能满足所有的方案
 * 1 <= n, m, bi <= 10^5
 * -(10^5) <= ki < 0
 */
public class Code03_GroupBuyTickets {

    public int enoughMoney(int n, int[][] games) {
        PriorityQueue<Game> heap = new PriorityQueue<>((a, b) -> b.earn() - a.earn());
        for (int[] g : games) {
            heap.add(new Game(g[0], g[1]));
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (heap.poll().earn() <= 0) {
                break;
            }
            Game cur = heap.poll();
            ans += cur.earn();
            cur.people++;
            heap.add(cur);
        }
        return ans;
    }


    public static class Game {
        public int ki;
        public int bi;
        public int people;

        public Game(int ki, int bi) {
            this.ki = ki;
            this.bi = bi;
            this.people = 0;
        }

        //项目如果再来人，能收多少钱（扣掉之前返回的钱）
        public int earn() {
            return (ki * (people + 1) + bi) + ki * people;
        }
    }
}







































