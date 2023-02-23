package leetcode;

import java.util.Stack;

/**
 * 70 leetcode 0020 有效的括号
 * 栈
 */
public class P_0020_validParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        char[] str = s.toCharArray();
        // 优化，可用数组代替栈
        Stack<Character> stack = new Stack<>();
        //char[] stack = new char[n];
        //int size = 0;
        for (int i = 0; i < n; i++) {
            char cur = str[i];
            if (cur == '(' || cur == '[' || cur == '{') {
                //是左括号的话，压入右括号
                stack.add(cur == '(' ? ')' : (cur == '[' ? ']' : '}'));
                //stack[size++] = cur == '(' ? ')' : (cur == '[' ? ']' : '}');
            } else {
                //size==0
                if (stack.isEmpty()) {
                    return false;
                }
                //  Character last = stack[--size];
                Character last = stack.pop();
                if (cur != last) {
                    return false;
                }
            }
        }
        //size==0
        return stack.isEmpty();
    }
}
