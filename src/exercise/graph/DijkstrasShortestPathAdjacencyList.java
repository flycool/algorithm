package exercise.graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * This file contains an implementation of Dijkstra's shortest path algorithm from a start node to a
 * specific ending node. Dijkstra can also be modified to find the shortest path between a starting
 * node and all other nodes in the graph. However, in this implementation since we're only going
 * from a starting node to an ending node we can employ an optimization to stop early once we've
 * visited all the neighbors of the ending node.
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
public class DijkstrasShortestPathAdjacencyList {

    public static class Edge {
        double cost;
        int from, to;

        public Edge(int to, int form, double cost) {
            this.to = to;
            this.from = form;
            this.cost = cost;
        }
    }

    public static class Node implements Comparable<Node> {
        int id;
        double value;

        public Node(int id, double value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return Double.compare(this.value, o.value);
        }
    }

    private final int n;
    private double[] dist;
    private Integer[] prev;
    private final List<List<Edge>> graph;

    public DijkstrasShortestPathAdjacencyList(int n) {
        this.n = n;
        this.graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
    }

    public List<List<Edge>> getGraph() {
        return graph;
    }

    /**
     * Reconstructs the shortest path (of nodes) from 'start' to 'end' inclusive.
     *
     * @return An array of node indexes of the shortest path from 'start' to 'end'. If 'start' and
     * 'end' are not connected then an empty list is returned.
     */
    public List<Integer> reconstructPath(int start, int end) {
        dijkstra(start, end);
        LinkedList<Integer> path = new LinkedList<>();
        if (dist[end] == Double.POSITIVE_INFINITY) {
            return path;
        }
        for (int at = end; at != start; at = prev[at]) {
            path.addFirst(at);
        }
        path.addFirst(start);
        return path;
    }

    /**
     * Runs Dijkstra's algorithm on a directed graph to find the shortest path from a starting node to
     * an ending node. If there is no path between the starting node and the destination node the
     * returned value is Double.POSITIVE_INFINITY.
     */
    public double dijkstra(int start, int end) {
        dist = new double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n];
        prev = new Integer[n];

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited[node.id] = true;

            if (dist[node.id] < node.value) {
                continue;
            }

            for (Edge edge : graph.get(node.id)) {
                if (visited[edge.to]) {
                    continue;
                }

                double newDist = dist[edge.from] + edge.cost;
                if (newDist < dist[edge.to]) {
                    prev[edge.to] = edge.from;
                    dist[edge.to] = newDist;
                    pq.offer(new Node(edge.to, dist[edge.to]));
                }
            }

            if (node.id == end) {
                return dist[end];
            }
        }
        return Double.POSITIVE_INFINITY;
    }
}





























