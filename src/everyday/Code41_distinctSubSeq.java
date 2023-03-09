package everyday;

//41 不同非空子序列的个数
public class Code41_distinctSubSeq {

    public int distinctSubSeq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int all = 1;//空集
        for (char c : str) {
            //纯新增 = 之前的集合数 - 上一个c字符加入后，c结尾的集合总数
            int newAdd = all - count[c - 'a'];
            all += newAdd;
            count[c - 'a'] += newAdd;
        }
        //不算空集，所以减1
        return all - 1;
    }

    //每次取mod
    public int distinctSubSeq2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = 1000000007;
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int all = 1;//空集
        for (char c : str) {
            //纯新增 = 之前的集合数 - 上一个c字符加入后，c结尾的集合总数
            int newAdd = (all - count[c - 'a'] + m) % m;
            all = (all + newAdd) % m;
            count[c - 'a'] = (count[c - 'a'] + newAdd) % m;
        }
        //不算空集，所以减1
        return (all - 1 + m) % m;
    }

}
