package base.class04_graph;

import java.util.*;

public class Code03_Prim {

    public static class EdgeCompator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph) {
        //小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeCompator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {//任意选一个点, 可能有多个不相连的森林
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();//最小的边
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {//新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

}
