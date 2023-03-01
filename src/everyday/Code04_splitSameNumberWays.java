package everyday;

/**
 * 4. 微软
 * 比如：str="ayxbx"
 * 有以下4种切法：a|yxbx，ay|xbx，ayx|bx，ayxbx
 * 其中第1，3，4种切法符合：x和y的个数，至少在左右两块中的一块里有相同的数量，所有返回3
 * 给定一个字符串str，长度为n
 * 你有n-1中划分方法，把str切成左右两半，返回有几种切法满足：
 * x和y的个数，至少在左右两块中的一块里有相同的数量
 */
public class Code04_splitSameNumberWays {

    public int splitSameNumberWays(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int xall = 0, yall = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'x') {
                xall++;
            } else if (str.charAt(i) == 'y') {
                yall++;
            }
        }
        int curx = 0, cury = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'x') {
                curx++;
            } else if (str.charAt(i) == 'y') {
                cury++;
            }
            boolean b = curx == cury || (xall - curx) == (yall - cury);
            ans += b ? 1 : 0;
        }
        return ans;
    }
}
