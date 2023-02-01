package jadvance.class03;

import java.util.LinkedList;

public class Code01_ExpressionCompute {

    /**
     * 优先级结合的问题，使用这种递归
     * 没有左右括号时，用栈或队列
     * 有左右括号时，递归：
     * 返回值有两个
     * 1）遇到右括号或结尾时，返回计算的值
     * 2）遇到右括号或结尾时，返回字符的位置
     */

    public static int expressionCompute(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    /**
     * 给定一个字符串str，str表示一个公式，公式里可能有正数，加减乘除符号和左右括号，
     * 返回公式的计算结果
     */
    public static int[] value(char[] chs, int i) {
        LinkedList<String> que = new LinkedList<>();
        int num = 0;
        int[] bra = null;

        while (i < chs.length && chs[i] != ')') {
            if (chs[i] <= '9' && chs[i] >= '0') {
                num = num * 10 + chs[i++] - '0';
            } else if (chs[i] != '(') { //遇到运算符号
                addNum(que, num);
                que.addLast(String.valueOf(chs[i++]));
                num = 0;
            } else {//遇到左括号
                bra = value(chs, i + 1);
                num = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, num);
        return new int[]{getNum(que), i};
    }

    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.add(top);
            } else {
                cur = Integer.parseInt(que.pollLast());
                num = top.equals("*") ? cur * num : cur / num;
            }
        }
        que.addLast(String.valueOf(num));
    }

    private static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        while (!que.isEmpty()) {
            String cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                res += add ? Integer.parseInt(cur) : -(Integer.parseInt(cur));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "4+5*(32+1-8)+4/2";//= 131
        int i = expressionCompute(str);
        System.out.println(i);
    }
}
