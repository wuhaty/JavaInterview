package Question.leetcode;

import java.util.*;

public class Q212 {

    class Trie{
        String word = "";
        Map<Character,Trie> children = new HashMap<>();

        public void insert(String s){
            Trie root = this;
            for (char c:s.toCharArray()) {
                if (!root.children.containsKey(c)) {
                    Trie child = new Trie();
                    root.children.put(c,child);
                }
                root = root.children.get(c);
            }
            root.word = s;
        }
    }

    int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        Q212 q = new Q212();
        char[][] board = {
                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
        };
        q.findWords(board,new String[]{"oath","pea","eat","rain"});
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();

        for (String s:words) {
            tree.insert(s);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,i,j,tree,set);
            }
        }

        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int i, int j, Trie tree, Set<String> set) {
        if (!tree.children.containsKey(board[i][j])) return;

        char ch = board[i][j];
        tree = tree.children.get(ch);
        if (!"".equals(tree.word)){
            set.add(tree.word);
        }

        board[i][j] = '#';
        for (int[] dir:dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x>=0 && y>=0 && x<board.length && y < board[0].length){
                dfs(board,x,y,tree,set);
            }
        }
        board[i][j] = ch;
    }
}
