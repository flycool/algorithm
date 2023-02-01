package base.class04_graph;

import java.util.*;

public class Code04_Kruskal {

    public static class MySets {
        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            return setMap.get(from) == setMap.get(to);
        }

        //和并集合
        public void union(Node from, Node to) {
            List<Node> fromNodes = setMap.get(from);
            List<Node> toNodes = setMap.get(to);
            for (Node toNode : toNodes) {
                fromNodes.add(toNode);
                setMap.put(toNode, fromNodes);
            }
        }
    }

    public static class EdgeCompator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> KruskalMST(Graph graph) {
        //TODO 用并查集代替
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeCompator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        HashSet<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!mySets.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                mySets.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
