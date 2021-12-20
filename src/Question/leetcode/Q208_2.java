package Question.leetcode;

public class Q208_2 {
    class Word{
        boolean isEnd = false;
        Word[] words = new Word[26];
    }

    Word word;

    public static void main(String[] args) {
        Q208_2 q = new Q208_2();
        q.insert("apple");
        q.search("apple");
        q.search("app");
        q.startsWith("app");
        q.insert("app");
        q.search("app");
    }

    public Q208_2() {
        word = new Word();
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Word w = this.word;

        for (int i = 0; i < word.length(); i++) {
            char c = cs[i];
            int index = (c-'a');
            if (w.words[index] == null) {
                w.words[index] = new Word();
            }
            w = w.words[index];
        }
        w.isEnd = true;
    }

    public boolean search(String word) {
        Word w = startsWithPrefix(word);
        return w!=null && w.isEnd;
    }

    public Word startsWithPrefix(String prefix) {
        char cs[] = prefix.toCharArray();
        Word w = this.word;

        for (int j = 0; j<cs.length; j++) {
            char c = cs[j];
            int index = (c-'a');

            if (w.words[index] == null) return null;
            w = w.words[index];
        }

        return w;
    }

    public boolean startsWith(String prefix) {
        return startsWithPrefix(prefix) != null;
    }
}
