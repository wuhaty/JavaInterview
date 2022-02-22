package Question.leetcode.book.interviewSummary;

public class I208 {

    public static void main(String[] args) {
        I208 q = new I208();
        q.insert("apple");
        q.search("apple");
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public I208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = this.root;
        int i = 0;
        while (i < cs.length){
            TrieNode child = cur.children[cs[i]-'a'];
            if (child == null) {
                child = new TrieNode();
                cur.children[cs[i]-'a'] = child;
            }
            cur = child;
            i++;
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode n = startsWithNode(word);
        return  n!= null && n.isEnd;
    }

    public TrieNode startsWithNode(String prefix) {
        TrieNode cur = this.root;
        char[] cs = prefix.toCharArray();
        int i = 0;
        while (i<cs.length){
            cur = cur.children[cs[i]-'a'];
            if (cur == null) return null;
            i++;
        }
        return cur;
    }

    public boolean startsWith(String prefix) {
        return startsWithNode(prefix) != null;
    }
}
