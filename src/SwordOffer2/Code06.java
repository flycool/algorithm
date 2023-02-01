package SwordOffer2;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class Code06 {

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public int[] reversePrintLink(Node node) {
        ArrayList<Integer> array = new ArrayList<>();
        Node cur = node;
        while (cur.next != null) {
            array.add(node.value);
            cur = node.next;
        }
        int[] ans = new int[array.size()];
        for (int i = array.size() - 1; i <= 0; i--) {
            ans[i] = array.get(i);
        }
        return ans;
    }

    public int[] reversePrintLink2(Node node) {
        int n = 0;
        Node cur = node;
        for (; cur != null; cur = cur.next) {
            ++n;
        }
        cur = node;
        int[] ans = new int[n];
        for (; cur != null; cur = cur.next) {
            ans[--n] = cur.value;
        }
        return ans;
    }
}