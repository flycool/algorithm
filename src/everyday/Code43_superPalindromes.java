package everyday;

/**
 * 43 给定范围上超级回文数的个数问题
 * 如果一个正整数自身是回文数,而且它也是一个回文数的平方（它的开方也是回文）,那么我
 * 们称这个数为超级回文数。
 * 左右对称 如：1221 12321
 * 现在,给定两个正整数L和R(以字符串形式表示)
 * 返回包含在范围[L,R]中的超级回文数的数目
 * 测试链接:https://Leetcode.cn/problems/super-palindromes/
 */
public class Code43_superPalindromes {

    public int superPalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        long limit = (long) Math.sqrt(r);
        int cnt = 0;
        long seed = 1;
        long enlarge = 0;
        do {
            //取一半来构成回文 123 -> 123321
            enlarge = enlarge2(seed);
            if (isValid(enlarge * enlarge, l, r)) {//平方是否为超级回文
                cnt++;
            }
            enlarge = enlarge1(seed);
            if (isValid(enlarge * enlarge, l, r)) {
                cnt++;
            }
            seed++;
        } while (enlarge < limit);
        return cnt;
    }


    //123 -> 12321
    public static long enlarge1(long n) {
        long ans = n;
        n /= 10;
        while (n != 0) {
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }

    //123 -> 123321
    public static long enlarge2(long n) {
        long ans = n;
        while (n != 0) {
            long a = n % 10;
            ans = ans * 10 + a;
            n /= 10;
        }
        return ans;
    }

    public boolean isValid(long ans, long l, long r) {
        return isPalindrome(ans) && ans >= l && ans <= r;
    }

    public boolean isPalindrome(long n) {
        // n = 3721837
        //help=1000000
        long help = 1;
        while (n / help >= 10) {
            help *= 10;
        }
        while (n != 0) {
            if (n / help != n % 10) {//判断首尾两数是否相等
                return false;
            }
            n = (n % help) / 10;//去掉头尾
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        long l = enlarge1(123);
        System.out.println(l);
    }

}
