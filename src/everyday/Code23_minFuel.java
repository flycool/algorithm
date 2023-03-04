package everyday;

import java.util.ArrayList;

//23 微软
//给定一个图，0为办公室，求油量耗费
public class Code23_minFuel {

    public static int cnt = 0;

    public int minFuel(int[] a, int[] b, int n) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            graph.get(a[i]).add(b[i]);
            graph.get(b[i]).add(a[i]);
        }
        int[] dfn = new int[n + 1];
        int[] size = new int[n + 1];
        int[] cost = new int[n + 1];
        cnt = 0;
        dfs(graph, 0, dfn, size, cost);
        return cost[0];
    }

    // cur: 当前节点的编号
    //dfn: cur为头，每个节点分配dfn序号
    //size: cur为头，子树的节点个数
    //cost: cur为头，所有节点汇聚到cur，废了多少油
    private void dfs(ArrayList<ArrayList<Integer>> graph, int cur, int[] dfn, int[] size, int[] cost) {
        dfn[cur] = ++cnt;
        size[cur] = 1;
        for (Integer next : graph.get(cur)) {
            if (dfn[next] == 0) {
                dfs(graph, next, dfn, size, cost);
                size[cur] += size[next];
                cost[cur] += cost[next];
                cost[cur] += (size[next] + 4) / 5; // 向上取整
            }
        }
    }
}
