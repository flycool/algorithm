package everyday;

/**
 * 42 无限环绕字符串寻找非空子串问题
 * 把字符串s看作"abcdefghijklmnopqrstuvwxyz "无限环绕字符串
 * 所以看起来是这样的:
 * ...zabcdefghiiklmnoparstuywxyzabcdefghijklmnoparstuvwxyzabcd...
 * 现在给定另一个字符串p。返回中不同的p的非空子串的数量
 * 测试链接:https://Leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */
public class Code42_wrapRoundString {

    public int findSubStringInWrapRoundString(String str) {

        char[] p = str.toCharArray();
        int n = p.length;
        int len = 1;//连续字长成长的长度
        int[] max = new int[256];
        max[p[0]] = 1;
        for (int i = 0; i < n; i++) {
            char cur = p[i];
            char pre = p[i - 1];
            if ((cur == 'a' && pre == 'z') || pre + 1 == cur) {
                len++;
            } else {
                len = 1;
            }
            max[cur] = Math.max(max[cur], len);
        }
        int ans = 0;
        for (int i = 0; i < 256; i++) {
            ans += max[i];
        }
        return ans;
    }
}
