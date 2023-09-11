package everyday;

/**
 * 62 来自亚马逊、谷歌、字节跳动、华为、蔚来NO
 * 给你一个字符串s，请你去除字符串中重复的字母
 * 使得每个字母只出现一次
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 * 测试链接：https://leetcode.cn/problems/remove-duplicate-letters/
 */
public class Code62_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        boolean[] enter = new boolean[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char[] stack = new char[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (!enter[cur - 'a']) {
                enter[cur-'a'] = true;
                while(size>0 && stack[size-1] > cur && cnt[stack[size-1]-'a'] > 0) {
                    enter[stack[size-1]-'a'] = false;
                    size--;
                }
                stack[size++] = cur;
            }
            cnt[cur - 'a']--;
        }
        return String.valueOf(stack, 0, size);
    }

}
