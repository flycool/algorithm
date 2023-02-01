package intermediate_promote.class05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Code02_ChooseWork {

    public static class Job {
        public int money;
        public int hard;

        public Job(int money, int hard) {
            this.money = money;
            this.hard = hard;
        }
    }

    public static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        }
    }

    //给定job数组，和表示所有人的能力的数组arr，返回int类型的数组，表示
    //在难度不超过自身能力值的情况下，选择报酬最高的工作。
    public static int[] getMoneys(Job[] jobarr, int[] ability) {
        Arrays.sort(jobarr, new JobComparator());//hard 从小到大，相同hard，money从大到小
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(jobarr[0].hard, jobarr[0].money);
        Job pre = jobarr[0];
        for (int i = 1; i < jobarr.length; i++) {
            if (jobarr[i].hard != pre.hard && jobarr[i].money > pre.money) {
                pre = jobarr[i];
                map.put(jobarr[i].hard, jobarr[i].money);
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ans.length; i++) {
            Integer key = map.floorKey(ability[i]);//小于或等于个人能力的最大值
            ans[i] = key == null ? 0 : map.get(key);
        }
        return ans;
    }

}
