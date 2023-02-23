package interview2022;

public class Code66_removeDuplicateLetter {

    // 在str中，没种字符都要保留一个，让最后的结果，字典序最小，并返回
    public String removeDuplicateLetter(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minACSIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            minACSIndex = str.charAt(minACSIndex) > str.charAt(i) ? i : minACSIndex;
            if (--map[str.charAt(i)] == 0) {
                break;
            }
        }
        return String.valueOf(str.charAt(minACSIndex) + removeDuplicateLetter(
                str.substring(minACSIndex + 1).replaceAll(String.valueOf(str.charAt(minACSIndex)), "")
        ));
    }
}
