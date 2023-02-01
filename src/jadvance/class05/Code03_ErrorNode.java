package jadvance.class05;

import java.util.ArrayList;
import java.util.List;

public class Code03_ErrorNode {

    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 一颗二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这颗二叉树不再
     * 是搜索二叉树，请找到这两个错误节点并返回。
     * 已知二叉树所有的节点的值都不一样，给定二叉树的头节点head，返回一个长度为2的
     * 二叉树节点类型的数组errs。
     *
     * 进阶：
     * 如果在原问题中的到了这两个错误节点，我们当然可以通过交换两个节点的节点值的方式
     * 让整棵二叉树重新成为搜索二叉树。
     * 但现在要求你不能这么做，而是在结构上完全交换这两个节点的位置，请实现调整函数。
     */

    //arr 为二叉树的中序遍历
    //第一次降序的前一个，第二次降序的后一个
    public static List<Node> errorNode(int[] arr) {
        int count = 0;
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                count++;
                if (count == 1) {
                    nodes.add(new Node(arr[i]));
                }
                if (count == 2) {
                    nodes.add(new Node(arr[i + 1]));
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        List<Node> nodes = errorNode(arr);
        for (Node node : nodes) {
            System.out.println(node.value);
        }
    }
}
