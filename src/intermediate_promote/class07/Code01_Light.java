package intermediate_promote.class07;

public class Code01_Light {

    public static int light(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int n = chars.length;
        int i = 0;
        int ans = 0;
        while (i < n) {
            if (chars[i] == 'X') {
                i++;
            } else {
                ans++;
                if (i + 1 == n) {
                    return ans;
                } else {
                    if (chars[i + 1] == 'X') {
                        i = i + 2;
                    } else {
                        i = i + 3;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "...XXXX...X.X....";
        int light = light(str);
        System.out.println(light);

    }
}
