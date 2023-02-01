package intermediate_promote.class02;

public class Code04_ConvertWays {

    public static int convertWays(int num) {
        if (num < 1) {
            return 0;
        }
        return process(String.valueOf(num).toCharArray(), 0);
    }

    //将给定的数转换为字符串， 1对应a，2对应b....26对应z，求可以转换的不同字符串的个数
    public static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int res = process(str, index + 1);
        if (index == str.length - 1) {
            return res;
        }
        if (((str[index] - '0') * 10 + (str[index + 1] - '0')) < 27) {
            res += process(str, index + 2);
        }
        return res;
    }

    public static int dpWays(int num) {
        if (num < 1) {
            return 0;
        }
        char[] chs = String.valueOf(num).toCharArray();
        int n = chs.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = chs[n - 1] == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (chs[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1] + (((chs[i] - '0') * 10 + (chs[i + 1] - '0')) < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int num = 123414;
        int i = convertWays(num);
        System.out.println(i);
        System.out.println(dpWays(num));
    }
}
