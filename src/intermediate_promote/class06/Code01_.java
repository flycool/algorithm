package intermediate_promote.class06;

import java.util.TreeMap;

public class Code01_ {

    private static class Node {
        public String value;
        public TreeMap<String, Node> treeMap;

        public Node(String value) {
            this.value = value;
            this.treeMap = new TreeMap<>();
        }
    }

    public static void print(String[] folderPaths) {
        if (folderPaths == null || folderPaths.length == 0) {
            return;
        }
        Node node = generateFolderTree(folderPaths);
        printProcess(node, 0);
    }

    public static Node generateFolderTree(String[] folderPaths) {
        Node head = new Node("");
        for (String folderPath : folderPaths) {
            String[] folerNames = folderPath.split("\\\\");
            Node cur = head;
            for (String folerName : folerNames) {
                if (!cur.treeMap.containsKey(folerName)) {
                    cur.treeMap.put(folerName, new Node(folerName));
                }
                cur = cur.treeMap.get(folerName);
            }
        }
        return head;
    }

    private static void printProcess(Node node, int level) {
        if (level != 0) {
            System.out.println(gen2nSpace(level) + node.value);
        }
        for (Node next : node.treeMap.values()) {
            printProcess(next, level + 1);
        }
    }

    private static String gen2nSpace(int level) {
        String res = "";
        for (int i = 1; i < level; i++) {
            res += "  ";
        }
        return res;
    }

    public static void main(String[] args) {
        String[] paths = {"a\\b\\c\\d", "a\\b\\e\\g", "d\\r\\v"};
        print(paths);
    }
}
