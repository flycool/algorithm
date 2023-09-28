package struct.trie;

import java.util.Arrays;

/**
 * 静态数组的方式 实现 前缀树
 */
public class Trie2 {

    private static final int max = 150001;
    private static final int[][] tree = new int[max][26];
    private static final int[] end = new int[max];
    private static final int[] pass = new int[max];
    private static int cnt;

    public void build() {
        cnt = 1; // 节点从1编号开始
    }

    public void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt; //分配节点
            }
            cur = tree[cur][path]; // 跳到下一个节点
            pass[cur]++;
        }
        end[cur]++;
    }

    public int search(String word) {
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return end[cur];
    }

    public int prefixNumber(String pre) {
        int cur = 1;
        for (int i = 0, path; i < pre.length(); i++) {
            path = pre.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    public void delete(String word) {
        if (search(word) > 0) {
            int cur = 1;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--pass[tree[cur][path]] == 0) {
                    tree[cur][path] = 0;
                    return;
                }
                cur = tree[cur][path];
            }
            end[cur]--;
        }
    }

    public void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = 0;
        }
    }
}
