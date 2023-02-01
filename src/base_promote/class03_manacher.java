package base_promote;

public class class03_manacher {

    //11211--->#1#1#2#1#1#
    private static char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }

    public static int maxLcpslength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];//回文半径数组
        int C = -1;//center
        int R = -1;// 回文右边界再往右一个位置，最大有效区域R-1位置
        int max = Integer.MIN_VALUE;
        //取每个位置的回文半径
        for (int i = 0; i != str.length; i++) {
            //i至少的回文区域，先给pArr[i]
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String s = "abc123321ab";
        int manacher = maxLcpslength(s);
        System.out.println(manacher);
    }

}
