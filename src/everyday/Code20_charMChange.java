package everyday;

/**
 * 20 字节
 * 给定一个只由小写字母组成的字符串str,长度为N
 * 给定一个只由0、1组成的数组arr,长度为N
 * arr [i] == 0 表示str中i位置的字符不许修改
 * arr [i] == 1 表示str中i位置的字符允许修改
 * 给定一个正数m,表示在任意允许修改的位置,可以把该位置的字符变成a~z中的任何一个可以修改m次
 * 返回在最多修改m次的情况下,全是一种字符的最长子串是多长
 * 1<=n,m<=10^5
 * 所有字符都是小写
 * （窗口）
 */
public class Code20_charMChange {

    public int maxLen(String str, int[] arr, int m) {
        char[] s = str.toCharArray();
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int res = oneCharChange(s, arr, c, m);
            ans = Math.max(ans, res);
        }
        return ans;
    }

    public int oneCharChange(char[] s, int[] arr, char c, int m) {
        int n = arr.length;
        int r = 0;
        int change = 0;
        int ans = 0;
        for (int l = 0; l < n; l++) {
            while (r < n) {
                if (s[l] == c) {
                    r++;
                    continue;
                }
                if (arr[l] == 0 || change == m) {
                    break;
                }
                change++;
                r++;
            }
            ans = Math.max(ans, r - l);
            if (s[l] != c && arr[l] == 1) {
                change--;
            }
            r = Math.max(r, l + 1);
        }
        return ans;
    }
}
