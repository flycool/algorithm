package jadvance.class01;

import base.class02_link.Linked;

public class Code03_Live {

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 约瑟夫环问题
     * <p>
     * 公式：
     * 从 y = x%i 推导
     * 旧编号 = (新编号-1 + s)%i + 1
     * s为被杀节点的编号 s=(m-1)%i + 1
     * 等效公式：
     * 旧编号 = (新编号+ m-1)%i + 1
     */
    public static Node josephuskill(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 0;// list size
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m); //service node position
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;//返回一个节点，所以指回自己
        return head;
    }

    //一共有i个节点，数到m就杀死节点，请返回最终活下来的节点 在有i个节点时候的编号
    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    //===============================

    // 0...n-1个人围成一圈，一次循环取用arr中的数字，
    //杀n-1轮，返回活的人的原始编号
    public static int live(int n, int[] arr) {
        return no(n, arr, 0);
    }

    public static int no(int i, int[] arr, int index) {
        if (i == 1) {
            return 1;
        }
        return (no(i - 1, arr, nextIndex(arr.length, index)) + arr[index] - 1) % i + 1;
    }

    public static int nextIndex(int size, int index) {
        return index == size - 1 ? 0 : index + 1;
    }
}
