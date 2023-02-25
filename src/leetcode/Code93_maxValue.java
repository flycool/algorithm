package leetcode;

/**
 * 93 特殊规则下删除s中的字符是整个价值最大
 * 给定一个只由0和1组成的字符串s
 * 假设下标从1开始，规定i位置的字符价值v[i]计算方式如下：
 * 1. i==1时，v[i]=1
 * 2. i>1 时，如果s[i]!=s[i-1]，v[i]=1
 * 3. i>1时，如果s[i]==s[i-1]，v[i]=v[i-1]+1
 * 你可以随意删除s中的字符，返回整个s的最大价值
 */
public class Code93_maxValue {

    public int maxValue(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = str[i] == '0' ? 0 : 1;
        }
        return process(arr, 0, 0, 0);
    }

    public int process(int[] arr, int index, int lastNum, int baseValue) {
        if (index == arr.length) {
            return 0;
        }
        int curValue = lastNum == arr[index] ? (baseValue + 1) : 1;
        //保留index位置字符
        int p1 = process(arr, index + 1, arr[index], curValue);
        //不保留
        int p2 = process(arr, index + 1, lastNum, baseValue);
        return Math.max(curValue + p1, p2);
    }
}
