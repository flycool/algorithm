package zuo2023;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个正数n,表示有多少个节点
 * 给定一个二维数组edges,表示所有无向边
 * edges[i]={a,b}表示a到b有一条无向边
 * edges一定表示的是一个无环无向图，也就是树结构
 * 每个节点可以染1、2、3三种颜色
 * 要求：非叶节点的相邻点一定要至少有两种和自己不同颜色的点
 * 返回一种达标的染色方案，也就是一个数组，表示每个节点的染色状况
 * 1<=节点数量<=10的5次方
 */
public class Code20_TreeDye {

    private final int[] rule1 = {1, 2, 3};
    private final int[] rule2 = {1, 3, 2};

    public int[] treeDye(int[][] edges, int n) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int head = -1;
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() >= 2) {
                head = i;
                break;
            }
        }
        int[] colors = new int[n];
        if (head == -1) {
            Arrays.fill(colors, 1);
        } else {
            colors[head] = 1;
            dfs(graph, head, 1, rule1, colors);
            for (int i = 1; i < graph.get(head).size(); i++) {
                dfs(graph, graph.get(head).get(i), 1, rule2, colors);
            }
        }
        return colors;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph,
                    int head, int level, int[] rule, int[] colors) {
        colors[head] = rule[level % 3];
        for (int next : graph.get(head)) {
            if (colors[next] == 0) {
                dfs(graph, next, level + 1, rule, colors);
            }
        }
    }
}
