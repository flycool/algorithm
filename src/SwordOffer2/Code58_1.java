package SwordOffer2;

/**
 * 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Code58_1 {

    public static String reverseWord(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] words = s.split("\\s+");
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        String res = sb.substring(0, sb.length() - 1);
        return res;
    }

    public static void main(String[] args) {
        String s = "a good   example";
        String s1 = reverseWord(s);
        System.out.println(s1);
    }

}
