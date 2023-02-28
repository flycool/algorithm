package leetcode;

//74 leetcode 0069 Sqrt(x)
//x开根号
//二分，向下取整
public class Code74_P_0069_sqrt {

    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 3) {
            return 1;
        }
        long l = 1, r = x, m = 0;
        long ans = 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int) ans;
    }
}
