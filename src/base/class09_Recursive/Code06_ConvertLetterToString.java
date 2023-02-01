package base.class09_Recursive;

/**
 * 规定1和A对应，2和B对应，3和C对应...
 * 那么一个数字字符串比如"111"，就可以转化为"AAA"，"AK"和"KA"
 * 给定一个只有数字字符串组成的str，返回有多少种转化结果
 */
public class Code06_ConvertLetterToString {

    //i之前的位置，如何转化已经做过决定了
    //i....之后，有多种转化结果
    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= 0 && str[i + 1] <= 6)) {
                res += process(str, i + 2);
            }
            return res;
        }
        //str[i] == '3'~'9'
        return process(str, i + 1);
    }

    public static void main(String[] args) {
        String numStr = "1123335";
        char[] chars = numStr.toCharArray();
        int res = process(chars, 0);
        System.out.println(res);
    }
}
