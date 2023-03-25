package Involve;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 7. 阿里
 * 给定int[][] meetings,比如
 * {   {66,70} // 0号会议截止时间66,获得收益70
 *     {25,90} // 1号会议截止时间25,获得收益90
 *     {50,30} // 2号会议截止时间50,获得收益30
 * }
 * 一开始的时间是0,任何会议都持续10的时间,
 * 但是一个会议一定要在该会议截止时间之前开始
 * 只有一个会议室,任何会议不能共用会议室,
 * 一旦一个会议被正确安排,将获得这个会议的收益
 * 请返回最大的收益
 */
public class Involve07_MaxMeetingScore {

    public int maxScore(int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); //Comparator.comparingInt(a -> a[0])
        // 小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time + 10 <= meetings[i][0]) {
                heap.add(meetings[i][1]);
                time += 10;
            } else {
                if (!heap.isEmpty() && heap.peek() < meetings[i][1]) {
                    heap.poll();
                    heap.add(meetings[i][1]);
                }
            }
        }
        int ans = 0;
        while (!heap.isEmpty()) {
            ans += heap.poll();
        }
        return ans;
    }
}
