package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 34 美团
 * 某天小美进入了一个迷宫探险,根据地图所示,这个迷宫里有无数个房间
 * 序号分别为1、2、3、...入口房间的序号为1
 * 任意序号为正整数x的房间,都与序号 2*x 和 2*x+1 的房间之间各有一条路径
 * 但是这些路径是单向的,即只能从序号为x的房间去到序号为 2*x 或 2*x+1 的房间
 * 而不能从2*x或2*x+1的房间去到序号为x的房间
 * 在任何时刻小美都可以选择结束探险并离开迷宫,但是离开之后将无法再次进入迷宫
 * 小美还提前了解了迷宫中宝藏的信息
 * 已知宝藏共有n个,其中第i个宝藏在序号为pi的房间,价值为wi
 * 且一个房间中可能有多个宝藏
 * 小美为了得到更多的宝藏,需要精心规划路线,她找到你帮忙
 * 想请你帮她计算一下,能获得的宝藏价值和最大值为多少
 * 第一行一个正整数n,表示宝藏数量。
 * 第二行为n个正整数p1,p2......pn,其中pi表示第i个宝藏在序号为pi的房间
 * 第三行为n个正整数w1,w2......wn,其中wi表示第i个宝藏的价值为wi
 * 1<=n<=40000,1<=pi<2^30,1<=w<=10^6
 */
public class Code34_roomGetMoney {

    public int pickMoney(int[][] values) {
        //values: {房间号，价值}
        Arrays.sort(values, (a, b) -> a[0] - b[0]);//按房间号从小到大排序
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<Integer> starts = new ArrayList<>();
        for (int[] value : values) {
            int room = value[0];
            int tmp = room;
            graph.put(room, new ArrayList<>());
            while (tmp != 0) {
                if (graph.containsKey(tmp)) {
                    graph.get(tmp).add(room);
                    break;
                }
                tmp /=2;
            }
            if (tmp == 0) {
                starts.add(room);
            }
        }
        HashMap<Integer, Integer> moneys = new HashMap<>();
        for (int[] value : values) {
            moneys.put(value[0], value[1]);
        }
        int ans = 0;
        for (int start : starts) {
            ans = Math.max(ans, maxValue(start, graph, moneys));
        }
        return ans;
    }

    private int maxValue(int room, HashMap<Integer, ArrayList<Integer>> graph,
                         HashMap<Integer, Integer> moneys) {
        if (graph.get(room).isEmpty()) {
            return moneys.get(room);
        }
        int next = 0;
        for (int nextRoom : graph.get(room)) {
            next = Math.max(next, maxValue(nextRoom, graph, moneys));
        }
        return next + moneys.get(room);
    }

}
