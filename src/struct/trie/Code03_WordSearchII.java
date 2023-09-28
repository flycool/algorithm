package struct.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3.
 * 在二维字符数组中搜索可能的单词
 * 给定一个mxn二维字符网格board和一个单词（字符串）列表words
 * 返回所有二维网格上的单词。单词必须按照字母顺序，通过相邻的单元格内的字母构成
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
 * 同一个单元格内的字母在一个单词中不允许被重复使用
 * 1<=m,n<=12
 * 1 <words.Length <3 1044
 * 1 <words[i].length <10
 * 时间复杂度，0(m*n*4^10)
 * 不管用不用前缀树都是这个复杂度，只不过前缀树可以大量剪枝，优化常数时间
 * 空间复杂度，O(words中所有字符串的全部字符数量)
 */
public class Code03_WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        build(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, 1, ans);
            }
        }
        clear();
        return ans;
    }

    // t: 前缀树的编号
    // return : 收集到的字符串个数
    private int dfs(char[][] board, int i, int j, int t, List<String> ans) {
        // 越界或走了回头路，返回0
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 0) {
            return 0;
        }
        char tmp = board[i][j];
        int road = tmp - 'a';
        t = tree[t][road];
        if (pass[t] == 0) {// 没路，或不需要走
            return 0;
        }
        //从当前位置出发，一共收集到几个字符串，共5个位置
        int fix = 0;
        if (end[t] != null) {
            fix++;
            ans.add(end[t]);
            end[t] = null;
        }
        board[i][j] = 0;// 已经走过的路设为0
        fix += dfs(board, i - 1, j, t, ans);
        fix += dfs(board, i + 1, j, t, ans);
        fix += dfs(board, i, j - 1, t, ans);
        fix += dfs(board, i, j + 1, t, ans);
        pass[t] -= fix;
        board[i][j] = tmp;//恢复现场
        return fix;
    }

    private static final int max = 10001;
    private static final int[][] tree = new int[max][26];
    private static final int[] pass = new int[max];
    private static final String[] end = new String[max];
    private static int cnt;

    public void build(String[] words) {
        int cnt = 1;
        for (String word : words) {
            int cur = 1;
            pass[cur]++;
            for (int i = 0, path; i < words.length; i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            end[cur] = word;
        }
    }

    public void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            pass[i] = 0;
            end[i] = null;
        }
    }
}



















