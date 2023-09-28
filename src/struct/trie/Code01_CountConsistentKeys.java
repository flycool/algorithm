package struct.trie;

import java.util.Arrays;

/**
 * 1.
 * 接头密匙
 * 牛牛和他的朋友们约定了一套接头密匙系统，用于确认彼此身份
 * 密匙由一组数字序列表示，两个密匙被认为是一致的，如果满足以下条件：
 * 密匙b的长度不超过密匙a的长度。
 * 对于任意0<=i<length(b),有b[i+1]-b[i]=a[i+1]-a[i]
 * 现在给定了m个密匙b的数组，以及n个密匙a的数组
 * 请你返回一个长度为m的结果数组ans,表示每个密匙b都有多少一致的密匙
 * 数组a和数组b中的元素个数均不超过10^5
 * 1<=m,n<=1000
 * 用前缀树方法：
 * 时间复杂度，0(a数组的数字个数*10)+0(b数组的数字个数*10)
 * 空间复杂度，0(a数组的数字个数*10)，这是树上的节点数量
 */
public class Code01_CountConsistentKeys {

    public int[] countConsistentKeys(int[][] b, int[][] a) {
        build();
        StringBuilder builder = new StringBuilder();
        //[3,6,50,10] -> "3#44#-40#"
        for (int[] nums : a) {
            builder.setLength(0);
            for (int i = 1; i < nums.length; i++) {
                builder.append(String.valueOf(nums[i] - nums[i - 1])).append("#");
            }
            insert(builder.toString());
        }
        int[] ans = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            builder.setLength(0);//清空
            int[] nums = b[i];
            for (int j = 1; j < nums.length; j++) {
                builder.append(String.valueOf(nums[j] - nums[j - 1])).append("#");
            }
            ans[i] = count(builder.toString());
        }
        clear();
        return ans;
    }

    private static final int max = 150001;
    private static final int[][] tree = new int[max][12];
    private static final int[] pass = new int[max];
    private static int cnt;

    public int path(char c) {
        if (c == '#') {
            return 10;
        } else if (c == '-') {
            return 11;
        } else {
            return c - '0';
        }
    }

    public void build() {
        cnt = 1;
    }

    public void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = path(word.charAt(i));
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt; //分配节点
            }
            cur = tree[cur][path]; // 跳到下一个节点
            pass[cur]++;
        }
    }

    public int count(String pre) {
        int cur = 1;
        for (int i = 0, path; i < pre.length(); i++) {
            path = path(pre.charAt(i));
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    public void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
        }
    }
}
