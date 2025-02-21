package everyday;

//import com.sun.org.apache.bcel.internal.classfile.StackMap;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 47 华为
 * 给你n个任务和m个工人
 * 每个任务需要一定的力量值才能完成
 * 需要的力量值保存在下标从0开始的整数数组tasks中
 * 第i个任务需要tasks[i]的力量才能完成
 * 每个工人的力量值保存在下标从0开始的整数数组workers中
 * 第j个工人的力量值为workers[j]
 * 每个工人只能完成一个任务
 * 且力量值需要大于等于该任务的力量要求值，即workers[j]>=tasks[i]
 * 除此以外，你还有pills个神奇药丸
 * 可以给一个工人的力量值增加strength
 * 你可以决定给哪些工人使用药丸
 * 但每个工人最多只能使用一片药丸
 * 给你下标从0开始的整数数组tasks和workers以及
 * 两个整数pills和strength,请你返回最多有多少个任务可以被完成。
 * 测试链接：https://leetcode.cn/problems/maximum-number-of-tasks-you-can-assign/
 */
public class Code47_MaxNumOfTasksYouCanAssign {


    public int maxTask(int[] tasks, int[] workers, int pills, int strength) {
        int l = 0;
        int r = tasks.length;
        int m, ans = 0;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        while (l <= r) {
            m = (l + r) / 2;
            if (yeah1(tasks, m - 1, workers, workers.length - 1, strength) < pills) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }


    private int yeah1(int[] tasks, int tr, int[] workers, int wr, int strength) {
        TreeMap<Integer, Integer> taskMap = new TreeMap<>();
        for (int i = 0; i <= tr; i++) {
            taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0));
        }
        int ans = 0;
        for (int i = 0; i <= wr; i++) {
            // 不吃药时，看看 <= workers[i] 的任务是什么
            Integer task = taskMap.floorKey(workers[i]);
            if (task != null) {
                int times = taskMap.get(task);
                if (times == 1) {
                    taskMap.remove(task);
                } else {
                    taskMap.put(task, times - 1);
                }
            } else {
                // 要吃药了
                task = taskMap.floorKey(workers[i] + strength);
                if (task == null) {
                    return Integer.MAX_VALUE;
                }
                ans++;
                int times = taskMap.get(task);
                if (times == 1) {
                    taskMap.remove(task);
                } else {
                    taskMap.put(task, times - 1);
                }
            }
        }
        return ans;
    }

    //O(n)
    //help[] 双端队列
    private int yeah2(int[] tasks, int tr, int[] workers, int wr, int strength, int[] help) {
        int l = 0, r = 0;
        int ti = 0;
        int ans = 0;
        for (int wi = 0; wi <= wr; wi++) {
            for (; ti <= tr && tasks[ti] <= workers[wi]; ti++) {
                help[r++] = ti;
            }
            if (l < r && tasks[help[l]] <= workers[wi]) {
                l++;
            } else {
                for (; ti <= tr && tasks[ti] <= workers[wi] + strength; ti++) {
                    help[r++] = ti;
                }
                if (l < r) {
                    ans++;
                    r--;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return ans;
    }
}


























