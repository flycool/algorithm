package intermediate_promote.class01;

public class Code04_ColorLeftRight {

    //预处理
    //RGRGR--->RRRGG
    public static int minPaint(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] right = new int[n];
        right[n - 1] = chs[n - 1] == 'R' ? 1 : 0;
        //i..n-1上有多少个R,利用预处理的方式
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (chs[i] == 'R' ? 1 : 0);
        }
        int res = right[0];
        int left = 0;
        //以i为分界线，res为总共最小移动的次数
        for (int i = 0; i < n - 1; i++) {
            left += chs[i] == 'G' ? 1 : 0;
            res = Math.min(res, left + right[i + 1]);
        }
        res = Math.max(res, left + (chs[n - 1] == 'G' ? 1 : 0));
        return res;
    }


    public static void main(String[] args) {
        String s = "RGRGR";
        System.out.println(minPaint(s));
    }
}
