package base.class04_graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Code05_Dijkstra {

    //Dijkstra算法

    /**
     * @return 从head出发到所有点的最小距离
     * （a,0）, (b,2), (c,5)
     */
    public static HashMap<Node, Integer> dijkstra(Node head) {
        //key: 从head出发到达的key
        //value: 从head出发到达key的最小距离
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minDistancd = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> nodeEntry : distanceMap.entrySet()) {
            Node node = nodeEntry.getKey();
            int distance = nodeEntry.getValue();
            if (!selectedNodes.contains(node)  && distance < minDistancd) {
                minNode = node;
                minDistancd = distance;
            }
        }
        return minNode;
    }

}
