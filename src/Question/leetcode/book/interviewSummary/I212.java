package Question.leetcode.book.interviewSummary;

import Question.leetcode.Q212;

import java.util.*;

public class I212 {

    class Trie{
        Map<Character,Trie> children = new HashMap<>();
        String word;
        boolean isEnd;

        public void insert(String word){
            char[] cs = word.toCharArray();
            Trie cur = this;
            for (char c:cs) {
                Trie next = cur.children.get(c);
                if (next == null) {
                    next = new Trie();
                    cur.children.put(c,next);
                }
                cur = next;
            }
            cur.word = word;
            cur.isEnd = true;
        }
    }

    int dirs[][] = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };


    public static void main(String[] args) {
        I212 q = new I212();
//        char[][] board = {
//                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
//        };
        char[][] board = {
                {'a'}
        };
        q.findWords(board,new String[]{"a"});
    }


    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        buildTrie(root,words);

        int n = board.length;
        int m = board[0].length;

        Set<String> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board,i,j,root,res);
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, Trie root, Set<String> res) {
        if (!root.children.containsKey(board[i][j])) return;

        char c = board[i][j];
        Trie next = root.children.get(c);
        if (next.isEnd) res.add(next.word);
        board[i][j] = '#';

        for (int[] dir:dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x>=0 && y>=0 && x<board.length && y<board[0].length){
                dfs(board,x,y,next,res);
            }
        }
        board[i][j] = c;
    }

    private void buildTrie(Trie root, String[] words) {
        for (String word:words) {
            root.insert(word);
        }
    }
}
