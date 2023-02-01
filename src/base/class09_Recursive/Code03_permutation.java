package base.class09_Recursive;

import java.util.ArrayList;

public class Code03_permutation {

    // 1打印一个字符串的全排列
    // 2要求不要出现重复的排列
    public static ArrayList<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        process(chars, 0, res);
        return res;
    }

    private static void process(char[] chars, int i, ArrayList<String> res) {
        if (i == chars.length) {
            res.add(String.valueOf(chars));
        }
        boolean[] isVisit = new boolean[26];
        for (int j = i; j < chars.length; j++) {
            if (!isVisit[chars[j] - 'a']) {
                isVisit[chars[j] - 'a'] = true;
                swap(chars, i, j);
                process(chars, i + 1, res);
                swap(chars, i, j);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> abc = permutation("abc");
        for (String s : abc) {
            System.out.println(s);
        }
    }
}
