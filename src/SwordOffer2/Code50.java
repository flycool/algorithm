package SwordOffer2;

/**
 *第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Code50 {

    public char findUniqChar(String s) {
        int n= s.length();
        if (n == 0) {
            return ' ';
        }
        int[] counter = new int[26];
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            ++counter[index];//第i个字母出现的次数
        }
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (counter[index] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
