package Involve;

/**
 * 8. 百度
 * 给定一个字符串str，和一个整数k
 * str子序列的字符种数必须是k种
 * 返回有多少子序列满足这个条件
 * 已知str中都是小写字母
 */
public class Involve08_SequenceKDiffKinds {

    public int sequenceKDiffKinds(String str, int k) {
        int n = str.length();
        char[] s = str.toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            int charIndex = s[i] - 'a';
            arr[charIndex]++;
        }
        return ways(arr, 0, k);
    }

    // arr[]: 每种字符的数量
    public int ways(int[] arr, int i, int restKind) {
        if (i == arr.length) {
            return restKind == 0 ? 1 : 0;
        } else {
            // 不要第i个字符
            int p1 = ways(arr, i + 1, restKind);
            int p2 = 0;
            if (arr[i] != 0) {
                //要第i个字符 ((1 << arr[i]) - 1) --> 2^n-1
                p2 = ((1 << arr[i]) - 1) * ways(arr, i + 1, restKind - 1);
            }
            return p1 + p2;
        }
    }

    public static void main(String[] args) {
        String str = "abaadkfkjlccckkkeee";
        int n = str.length();
        char[] s = str.toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            int charIndex = s[i] - 'a';
            arr[charIndex]++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ",");
        }
    }
}
