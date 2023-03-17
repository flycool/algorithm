package everyday;

/**
 * 11. 腾讯
 * 给定一个字符串str，和一个正数k
 * 返回长度为k的所有子序列中，字典序最大的子序列
 */
public class Involve11_MaxKLenSequence {

    public String maxString(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray();
        char[] stack = new char[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && str[stack[size - 1]] > str[i] && size + n - i > k) {
                size--;
            }
            if (size + n - i == k) {
                return String.valueOf(stack, 0, size) + s.substring(i);
            }
            stack[size++] = str[i];
        }
        return String.valueOf(stack, 0, k);
    }
}
