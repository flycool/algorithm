package struct.trie;

// 前缀树
// 每个样本，都从头节点开始，根据前缀字符或者前缀数字，建出来的一颗大树，就是前缀树
// 没有路就新建节点，已经有路了，就复用节点
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        node.pass++;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new TrieNode();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    public void erase(String word) {
        // 出现过才能删除
        if (countWordsEqual(word) > 0) {
            TrieNode node = root;
            node.pass--;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }

    public int countWordsEqual(String word) {
        TrieNode node = root;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    public int countWordsStartingWith(String pre) {
        TrieNode node = root;
        for (int i = 0, path; i < pre.length(); i++) {
            path = pre.charAt(i) - 'a';
            if (node.nexts[path] == null) {
                return 0;
            }
            node = node.nexts[path];
        }
        return node.pass;
    }

    static class TrieNode {
        private int pass;
        private int end;
        private final TrieNode[] nexts; //  字符数量大时， 可用 HashMap 代替

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

}
