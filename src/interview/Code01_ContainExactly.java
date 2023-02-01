package interview;

public class Code01_ContainExactly {

    public static int containExactly(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() > s1.length()) {
            return -1;
        }
        char[] chars1 = s1.toCharArray();
        char[] aim = s2.toCharArray();

        int[] map = new int[256];
        for (char c : aim) {
            map[c]++;
        }
        int m = aim.length;
        int r = 0;
        int invalidTimes = 0;
        //先让窗口拥有m个字符
        for (; r < m; r++) {
            if (map[chars1[r]]-- <= 0) {
                invalidTimes++;
            }
        }
        // r=m
        for (; r < chars1.length - m; r++) {
            if (invalidTimes == 0) {
                return r - m;
            }
            if (map[chars1[r]]-- <= 0) {
                invalidTimes++;
            }
            if (map[chars1[r - m]]++ < 0) {
                invalidTimes--;
            }
        }
        return invalidTimes == 0 ? r - m : -1;
    }
}
