package interview2022;

/**
 * 给定一个只由a和b组成的字符串str，
 * str中的ab和ba子串都可以消除，
 * 消除之后剩下字符会重新靠在一起，继续出现可以消除的子串...
 * 你的任务是决定一种消除的顺序，最后让str消除到尽可能的短
 * 返回尽可能短的剩余字符串
 */
public class Code21_ABDisappear {

    public String disappear(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[] stack = new int[n];// 存放 str 的 index
        int size = 0;
        for (int i = 0; i < n; i++) {
            boolean hasA = size != 0 && str[stack[size - 1]] == 'a';
            boolean hasB = size != 0 && str[stack[size - 1]] == 'b';
            hasA |= str[i] == 'a';
            hasB |= str[i] == 'b';
            if (hasA && hasB) {
                size--;
            } else {
                stack[size++] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(str[stack[i]]);
        }
        return sb.toString();
    }
}
