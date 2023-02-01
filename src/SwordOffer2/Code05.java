package SwordOffer2;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class Code05 {

    public  static String replaceBlank(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String re = replaceBlank(s);
        System.out.println(re);
    }
}
