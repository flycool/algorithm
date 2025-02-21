package struct.slidewindow;

/**
 * 4.
 * 加油站
 * 在一条环路上有n个加油站，其中第i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，
 * 从第i个加油站开往第i+1个加油站需要消耗汽油cost[i]升
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组gas和cost,如果你可以按顺序绕环路行驶一周
 * 则返回出发时加油站的编号，否则返回-1
 * 如果存在解，则保证它是唯一的。
 * 测试链接：https://leetcode.cn/problems/gas-station/
 */
public class Code04_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int len = 0;
        int sum = 0;
        for (int l = 0, r = 0; l < n; l++) {
            while (sum >= 0) { // 判断差值累加和是否>=0
                if (len == n) {
                    return l;
                }
                r = (l + (len++)) % n; // 窗口即将进来的位置
                sum += gas[r] - cost[r];
            }
            len--;
            sum -= gas[l] - cost[l];// l向右移，吐出一个数字
        }
        return -1;
    }
}
