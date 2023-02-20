package interview2022;

import java.util.LinkedList;

/**
 * 45 公式字符串的结算结果
 * 给定一个字符串str，str表示一个公式
 * 公式里可能有整数，加减乘除符号和左右括号
 * 返回公式的计算结果
 * 难点在于括号可能嵌套很多层
 * str="48*((70-65)-43)+8+1"，返回-1816
 * str="3+1*4"， 返回7
 * str="3+(1*4)"，返回7
 * 说明：
 * 1.可以认为给定的字符串一定是正确的公式，即不需要对str检查
 * 2.如果是负数，就需要用括号括起来，比如： "4*(-3)" 但如果负数作为公式的开头或括号部分的开头，则可以没有括号，比如 "-3*4" 和 "(-3*4)" 都是合法的
 * 3.不用考虑计算过程中会发生溢出的情况
 */
public class Code45_BracketCalculate {

    public int calculate(String str) {
        return f(str.toCharArray(), 0)[0];
    }

    public int[] f(char[] str, int i) {
        LinkedList<String> que = new LinkedList<>();
        int cur = 0;
        int[] res = null;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {
                cur = cur * 10 + str[i++] - '0';
            } else if (str[i] != '(') {
                addNum(que, cur);
                que.addLast(String.valueOf(str[i++]));
                cur = 0;
            } else { // 遇到左括号
                res = f(str, i + 1);
                cur = res[0];
                i = res[1] + 1;
            }
        }
        addNum(que, cur);
        return new int[]{getResult(que), i};
    }

    public void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public int getResult(LinkedList<String> que) {
        int res = 0;
        String cur = null;
        boolean add = true;
        int num = 0;
        if (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
