package everyday;


import java.util.PriorityQueue;
import static java.util.Arrays.sort;

/**
 * 35 亚马逊
 * 有n名工人。给定两个数组quality 和wage
 * 其中quality[i]表示第i名工人的工作质量,其最低期望工资为wage[i]
 * 现在我们想雇佣k名工人组成一个工资组。在雇佣一组k名工人时,
 * 我们必须按照下述规则向他们支付工资:
 * 对工资组中的每名工人,应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 雇佣k个人时，最少花费多少
 * 测试链接:
 * https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/
 * (垃圾指数，价值/工作质量)
 */
public class Code35_minCostWorker {

    public class Employee {
        public double rubbishDegree;
        public int quality;

        public Employee(int wage, int quality) {
            this.rubbishDegree = (double) wage / (double) quality;
            this.quality = quality;
        }
    }

    public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee(wage[i], quality[i]);
        }
        sort(employees, (a, b) -> a.rubbishDegree <= b.rubbishDegree ? -1 : 1);
        PriorityQueue<Integer> minTops = new PriorityQueue<>((a, b) -> b - a);//小根堆
        double ans = Double.MAX_VALUE;
        for (int i = 0, qualitySum = 0; i < n; i++) {
            int curQuality = employees[i].quality;
            if (minTops.size() < k) {
                qualitySum += curQuality;
                minTops.add(curQuality);
                if (minTops.size() == k) {
                    ans = Math.min(ans, qualitySum * employees[i].rubbishDegree);
                }
            } else {
                if (minTops.peek() > curQuality) {
                    qualitySum += curQuality - minTops.poll();
                    minTops.add(curQuality);
                }
                ans = Math.min(ans, qualitySum * employees[i].rubbishDegree);
            }
        }
        return ans;
    }
}
