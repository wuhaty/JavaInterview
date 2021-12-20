package Question.leetcode;

public class Q208 {
    Q208[] trie;
    boolean isEnd;

    public Q208() {
        trie = new Q208[26];
        isEnd = false;
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Q208 node = this;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            int index = c - 'a';
            if (node.trie[index] == null){
                node.trie[index] = new Q208();
            }
            node = node.trie[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Q208 node =searchPrefix(word);
        return node != null && node.isEnd;
    }

    public Q208 searchPrefix(String word) {
        char[] cs = word.toCharArray();
        Q208 node = this;

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            int index = c - 'a';
            if (node.trie[index] == null) return null;
            node = node.trie[index];
        }

        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
