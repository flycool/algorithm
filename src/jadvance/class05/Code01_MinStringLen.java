package jadvance.class05;

import java.util.HashMap;

public class Code01_MinStringLen {

    //给定字符串str1和str2，求str1的子串含有str2所有字符的最小串长度，不管顺序
    //词频统计str2，窗口滑动
    public static int minLen(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 1;
        int all = chs2.length;
        for (char c : chs2) {
            if (!map.containsKey(c)) {
                map.put(c, count);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int r = 0;
        int min = Integer.MAX_VALUE;
        for (int l = 1; l <= chs1.length; l++) {
            Character c = chs1[l - 1];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) > 0) {
                    all++;
                }
            }
            while (r < chs1.length && all > 0) {
                Character cr = chs1[r++];
                if (map.containsKey(cr)) {
                    map.put(cr, map.get(cr) - 1);
                    if (map.get(cr) >= 0) {
                        all--;
                    }
                }
            }
            if (all == 0) {
                min = Math.min(min, r - l);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
//        String str1 = "abbbcdfd";
//        String str2 = "bbcdd";
        String str1 = "aaaabbcacbba";
        String str2 = "aaa";
        int i = minLen(str1, str2);
        System.out.println(i);


    }
}
