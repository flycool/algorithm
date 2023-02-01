package base_promote;

import java.util.List;

/**
 * 给定一颗多叉树的头结点boss，返回派对的最大快乐值
 * 如果某个员工来了，那么这个员工的所有下级都不能来
 */
public class class07_maxHappy {

    public class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy, List<Employee> nexts) {
            this.happy = happy;
            this.nexts = nexts;
        }
    }

    public class Info {
        public int laiMaxHappy;
        public int buMaxHappy;

        public Info(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public int maxHappy(Employee boss) {
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }

    public Info process(Employee x) {
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int lai = x.happy;
        int bu = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai, bu);
    }

}
