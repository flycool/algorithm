package leetcode;

//92 长度为k的字典序最大子序列
public class Code92_MaxLenSequence {

    public String maxLenSequence(String s, int k) {
        if (k <= 0 || s.length() < k) {
            return "";
        }
        char[] str = s.toCharArray();
        int n = s.length();
        char[] stack = new char[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && stack[size - 1] < str[i] && size + n-i > k) {
                size--;
            }
            if (size + n - i == k) {//正好k个
                return String.valueOf(stack, 0, size) + s.substring(i);
            }
            stack[size++] = str[i];
        }
        return String.valueOf(stack, 0, k);
    }
}
