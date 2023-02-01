package intermediate_promote.class07;

public class Code05_mod3 {

    //那个数组合起来成一个数，求是否能被3整除
    public static boolean isMOd3(int n) {
        int sum = (1 + n) * n / 2;
        if (sum % 3 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s);
        int si = Integer.valueOf(s);
        boolean mOd3 = isMOd3(si);
        System.out.println(mOd3);
    }
}
