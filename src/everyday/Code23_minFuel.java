package everyday;

import java.util.ArrayList;

/**
 * 23 and 33 微软
 * 给定两个数组A和B，比如
 * A={0,1,1}
 * B={1,2,3}
 * A[0]=0，B[0]=1，表示0到1有双向道路
 * A[1]=1，B[1]=2，表示1到2有双向道路
 * A[2]=1，B[2]=3，表示1到3有双向道路
 * 给定数字N，编号从0~N，所以一共N+1个节点
 * 题目输入一定保证所有节点都联通，并且一定没有环
 * 默认办公室是0节点，其他1~N节点上，每个节点上都有一个居民
 * 每天所有居民都去往0节点上班
 * 所有的居民都有一辆5座的车,也都乐意和别人一起坐车
 * 车不管负重是多少,只要走过一条路,就耗费1的汽油
 * 比如A、B、C的居民,开着自己的车来到D居民的位置,一共耗费3的汽油
 * D居民和E居民之间,假设有一条路
 * 那么D居民可以接上A、B、C,4个人可以用一辆车,去往E的话,就再耗费1的汽油
 * 求所有居民去办公室的路上,最少耗费多少汽油
 */
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
