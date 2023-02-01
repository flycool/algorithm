package intermediate_promote.class08;

public class Code04_MaxLength {


    //在一个字符串中找到没有重复字符子串中最长的长度。
    //子串是连续的
    public static int maxLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            //pre为i-1往前推的最大长度所在的位置，map[chars[i]为上一次出现的位置
            //去两者最大值
            pre = Math.max(pre, map[chars[i]]);
            cur = i - pre;
            len = Math.max(cur, len);
            map[chars[i]] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "abcsddegekji";
        System.out.println(maxLength(str));
    }
}
