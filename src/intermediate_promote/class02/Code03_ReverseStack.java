package intermediate_promote.class02;

import java.util.Stack;

public class Code03_ReverseStack {
    //把一个stack逆序,只能用一个额外的stack
    public static Stack reverseStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack();
        helpStack.add(stack.pop());
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            while (pop > helpStack.peek()) {
                int htop = helpStack.pop();
                stack.add(htop);
            }
            helpStack.add(pop);
        }
        while (!helpStack.isEmpty()) {
            stack.add(helpStack.pop());
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(5);
        stack.add(3);
        stack.add(6);
        stack.add(7);
        System.out.println(stack);
        Stack recu = reverseStack(stack);
        System.out.println(recu);
    }
}
