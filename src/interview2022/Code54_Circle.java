package interview2022;

/**
 * 54.约瑟夫环问题
 * 给定一个链表的头结点head，和一个正数m
 * 从头开始，每次数到m就杀死当前结点
 * 然后被杀结点的下一个结点从1开始重新数
 * 周而复始直到只剩一个结点，返回最后的节点
 * <p>
 * 反着推
 * y=x%i===> y=(x-1)%i+1
 * 公式：
 * 前 = (后 + m - 1) % n +1
 */
public class Code54_Circle {

    public int gameLive(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return (gameLive(n - 1, m) + m - 1) % n + 1;
    }
}
