package zuo2025.essential.class38_recursion;

import java.util.HashSet;

public class C01_SubSequences {

    // https://leetcode.com/problems/subsequence-with-the-minimum-score/
    // 1. 返回字符串全部子序列，子序列要求去重。时间复杂度O((2^n)*n)
    public String[] generatePermutation1(String str) {
        char[] s = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        f1(s, 0, new StringBuilder(), set);
//        f2(s, 0, new char[s.length], 0, set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }

    private void f1(char[] s, int i, StringBuilder path, HashSet<String> set) {
        if (i == s.length) {
            set.add(path.toString());
        } else {
            path.append(s[i]);
            f1(s, i + 1, path, set);
            path.deleteCharAt(path.length() - 1);
            f1(s, i + 1, path, set);
        }
    }

    private void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
        if (i == s.length) {
            set.add(String.valueOf(path, 0, size));
        } else {
            path[size] = s[i];
            f2(s, i + 1, path, size + 1, set);
            f2(s, i + 1, path, size, set);
        }
    }

}
