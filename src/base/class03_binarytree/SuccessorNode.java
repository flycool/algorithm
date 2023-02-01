package base.class03_binarytree;

/**
 * 在二叉树中找到一个节点的后继节点
 */
public class SuccessorNode {

    class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    //在二叉树中找到一个节点的后继节点
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {//无右树
            Node parent = node.parent;
            if (parent != null && parent.left != null) {//当前节点是其父亲节点右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
