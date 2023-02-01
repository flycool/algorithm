package base.class03_binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class serial {


    //二叉树序列化
    public static String serialByPre(Node node) {
        if (node == null) {
            return "#_";
        }
        String res = node.value + "_";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }

    //二叉树反序列化
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
