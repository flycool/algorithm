package zuo2023;

import java.util.Stack;

/**
 * 给定一个逆波兰式
 * 转化成正确的中序表达式
 * 要求只有必要加括号的地方才加括号
 */
public class Code21_ReversePolishNotation {

    enum Opertation {
        SingleNumber, AddOrMinus, MultiplyOrDivide
    }

    public  static String convert(String rpn) {
        if (rpn == null || "".equals(rpn)) {
            return rpn;
        }
        Stack<String> stack1 = new Stack<>();
        Stack<Opertation> stack2 = new Stack<>();
        String[] parts = rpn.split(" ");
        for (String cur : parts) {
            if (cur.equals("+") || cur.equals("-")) {
                String b = stack1.pop();
                String a = stack1.pop();
                stack2.pop();
                stack2.pop();
                stack1.push(a + cur + b);
                stack2.push(Opertation.AddOrMinus);
            } else if (cur.equals("*") || cur.equals("/")) {
                String b = stack1.pop();
                String a = stack1.pop();
                Opertation bOp = stack2.pop();
                Opertation aOp = stack2.pop();
                String left = aOp == Opertation.AddOrMinus ? ("(" + a + ")") : (a);
                String right = bOp == Opertation.AddOrMinus ? ("(" + b + ")") : (b);
                stack1.push(left + cur + right);
                stack2.push(Opertation.MultiplyOrDivide);
            } else {
                stack1.push(cur);
                stack2.push(Opertation.SingleNumber);
            }
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        //3*(-5+13)+6/(2-3+2)-4*5*3
        String rpn = "3 -5 13 + * 6 2 3 - 2 + / + 4 5 3 * * -";
        System.out.println(convert(rpn));
    }
}
