package intermediate_promote.class08;

public class Code06_RemoveLetter {
    //给定一个全是小写字母的字符串str，删除多余的字符，使得每种字符只保留一个，
    //并让最终结果的字符串的字典序最小
    public static String remove(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            //生成词频表
            map[str.charAt(i)]++;
        }
        int minAscIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (--map[str.charAt(i)] == 0) {
                break;
            } else {
                //选ascii码最小的字符
                minAscIndex = str.charAt(minAscIndex) > str.charAt(i) ? i : minAscIndex;
            }
        }
        return str.charAt(minAscIndex) +
                remove(str
                        .substring(minAscIndex + 1)
                        .replaceAll(String.valueOf(str.charAt(minAscIndex)), ""));
    }
}
