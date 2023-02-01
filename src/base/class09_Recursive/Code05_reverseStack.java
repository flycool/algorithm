package base.class09_Recursive;

import java.util.Stack;

public class Code05_reverseStack {

    //给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverseStack(stack);
        stack.push(i);
    }

    private static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverseStack(stack);
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
