package zuo2025.essential.class26;

import java.util.PriorityQueue;

// 让正数整体累加和减半的最少操作次数
// https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
public class C03_MinimumOperationsToHalveArraySum {

    public int halveArray(int[] arr) {
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int j : arr) {
            heap.add((double) j);
            sum += j;
        }
        sum /= 2;
        int ans = 0;
        double cur = 0d;
        for (double minus = 0; minus < sum; ) {
            cur = heap.poll() / 2;
            heap.add(cur);
            minus += cur;
            ans++;
        }
        return ans;
    }
}
