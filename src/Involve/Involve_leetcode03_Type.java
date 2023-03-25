package Involve;

import java.util.HashSet;

/**
 * 3. 快手
 * 如果两个字符串，所含字符种类完全一样，就算作一类
 * 只由小写字母组成的一批字符串
 * 都放在字符类型的数组String[] arr 中，返回arr中一共有多少类
 */
public class Involve_leetcode03_Type {

    public int types(String[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (String s : arr) {
            int key = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                key |= (1 << (chars[i] - 'a'));
            }
            set.add(key);
        }
        return set.size();
    }
}
