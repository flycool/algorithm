package intermediate_promote.class05;

public class Code03_ValidNumber {

    //给定一个字符串，如符合人们日常书写的一个正数形式，返回int类型的这个数，
    //如不符合或越界返回-1或报错
    public static int convert(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            throw new RuntimeException("can not convert");
        }
        boolean neg = str[0] == '-';
        final int minq = Integer.MIN_VALUE / 10;
        final int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = neg ? 1 : 0; i < str.length; i++) {
            cur = '0' - str[i];//以负数接受
            //越界判断
            if (res < minq || (res == minq && cur < minr)) {
                throw new RuntimeException("can not convert");
            }
            res = res * 10 + cur;
        }
        if (!neg && (res == Integer.MIN_VALUE)) {
            throw new RuntimeException("can not convert");
        }
        return neg ? res : -res;
    }

    public static boolean isValid(char[] str) {
        if (str[0] != '-' && (str[0] < '0' || str[0] > '9')) {
            return false;
        }
        if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
            return false;
        }
        if (str[0] == '0' && str.length > 1) {
            return false;
        }
        for (char c : str) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
