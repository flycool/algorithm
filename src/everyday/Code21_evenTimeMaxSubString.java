package everyday;

import java.util.HashMap;

/**
 * 21 微软
 * 给定一个字符串s，其中都是英文小写字母
 * 如果s中的子串含有的  每种字符都是偶数个
 * 那么这样的子串就是达标子串，子串要求是连续串
 * 返回s中达标子串的最大长度
 * 1<=S的长度<=10^5
 * 字符种类都是英文小写
 * （用hashmap记录每个状态最早出现的位置 j，则j+1到i就是最大达标子串长度）
 */
public class Code21_evenTimeMaxSubString {

    // O(n)
    public int maxLen(String s) {
        // (status : 最早出现的位置)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int status = 0;
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 把当前字符偶数的状态存到map里，下次出现相同状态再取出来
            status ^= 1 << (s.charAt(i) - 'a');
            if (map.containsKey(status)) {
                ans = Math.max(ans, i - map.get(status));
            } else {
                map.put(status, i);
            }
        }
        return ans;
    }

}
