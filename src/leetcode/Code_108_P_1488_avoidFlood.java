package leetcode;

import java.util.*;

//109 leetcode 1488 避免洪水泛滥
public class Code_108_P_1488_avoidFlood {

    //rains[i]=j，第i天轮到j号湖下雨
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        int[] invalid = new int[0];
        //key:某个胡
        //value:这个湖在哪些天下雨
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] != 0) {
                if (!map.containsKey(rains[i])) {
                    map.put(rains[i], new LinkedList<>());
                }
                map.get(rains[i]).addLast(i);
            }
        }
        // 没抽干的湖的集合
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Work> heap = new PriorityQueue<Work>();
        for (int i = 0; i < n; i++) {
            if (rains[i] != 0) {
                if (set.contains(rains[i])) {
                    return invalid;
                }
                set.add(rains[i]);
                map.get(rains[i]).pollFirst();
                if (!map.get(rains[i]).isEmpty()) {
                    heap.add(new Work(rains[i], map.get(rains[i]).peekFirst()));
                }
                ans[i] = -1;
            } else {
                if (heap.isEmpty()) {
                    ans[i] = 1;
                } else {
                    Work curWork = heap.poll();
                    set.remove(curWork.lake);
                    ans[i] = curWork.lake;
                }
            }
        }
        return ans;
    }

    public static class Work implements Comparable<Work> {
        public int lake;
        public int nextRainDay;

        public Work(int lake, int nextRainDay) {
            this.lake = lake;
            this.nextRainDay = nextRainDay;
        }

        @Override
        public int compareTo(Work o) {
            return nextRainDay - o.nextRainDay;
        }
    }
}
