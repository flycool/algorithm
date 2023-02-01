package base.class09_Recursive;

public class Code02_PrintAllSubsquence {

    //打印一个字符串的全部子序列，包括空字符串
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    private static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);// 要当前字符的路
        char temp = chs[i];
        chs[i] = '_';
        process(chs, i + 1);// 不要当前字符的路
        chs[i] = temp;
    }

    public static void main(String[] args) {
        printAllSubsquence("abc");
    }
}
