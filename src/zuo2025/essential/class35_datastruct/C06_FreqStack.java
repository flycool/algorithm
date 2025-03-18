package zuo2025.essential.class35_datastruct;

import java.util.ArrayList;
import java.util.HashMap;

public class C06_FreqStack {

    // 6. 最大频率栈
    // https://leetcode.com/problems/maximum-frequency-stack/
    static class FreqStack {
        private int topTimes;
        private HashMap<Integer, ArrayList<Integer>> cntValues = new HashMap<>();
        private HashMap<Integer, Integer> valueTimes = new HashMap<>(); // 词频表

        public void push(int val) {
            valueTimes.put(val, valueTimes.getOrDefault(val, 0) + 1);
            int curTopTimes = valueTimes.get(val);
            if (!cntValues.containsKey(curTopTimes)) {
                cntValues.put(curTopTimes, new ArrayList<>());
            }
            cntValues.get(topTimes).add(val);
            topTimes = Math.max(topTimes, curTopTimes);
        }

        public int pop() {
            ArrayList<Integer> topTimeValues = cntValues.get(topTimes);
            int ans = topTimeValues.remove(topTimeValues.size() - 1);
            if (topTimeValues.isEmpty()) {
                cntValues.remove(topTimes--);
            }
            int times = valueTimes.get(ans);
            if (times == 1) {
                valueTimes.remove(ans);
            } else {
                valueTimes.put(ans, times - 1);
            }
            return ans;
        }
    }
}
