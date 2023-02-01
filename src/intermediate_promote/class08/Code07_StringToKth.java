package intermediate_promote.class08;

public class Code07_StringToKth {
    //{a...z}字典序的子序列
    //给定一个数字，求它的子序列
    //或给定一个子序列，求它在第几

    //以i号字符开头，长度为len，总共的子序列
    public static int g(int i, int len) {
        if (len == 1) {
            return i;
        }
        int sum = 0;
        for (int j = i + 1; j <= 26; j++) {
            sum += g(j, len - 1);
        }
        return sum;
    }

    //长度为len的子序列有多少
    public static int f(int len) {
        int res = 0;
        for (int j = 1; j <= 26; j++) {
            res += g(j, len);
        }
        return res;
    }

    public static int kth(String str) {
        int len = str.length();
        char[] chs = str.toCharArray();
        int res = 0;
        //先算所有长度小于len的数量
        for (int i = 1; i < len; i++) {
            res += f(i);
        }
        //再算从'a'到第一个字符的所有字符，长度为len的数量
        int first = chs[0] - 'a' + 1;//第一个字符
        for (int i = 1; i < first; i++) {
            res += g(i, len);
        }

        int pre = first;
        for (int i = 1; i < len; i++) {//从i=1,第2个开始
            int cur = chs[i] - 'a' + 1;
            for (int j = pre + 1; j < cur; j++) {
                res += g(j, len - i);
            }
            pre = cur;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        String str = "djv";
        int kth = kth(str);
        System.out.println(kth);
    }
}
