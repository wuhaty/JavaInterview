package Question.leetcode;

public class Q79 {

    int[][] dirs = {
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) {
        Q79 q = new Q79();
//        char[][] t= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] t= {{'a'}};

        q.exist2021(t,"a");
    }

    public boolean exist(char[][] board, String word) {
        char[] cs = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board,word,i,j,0,visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int length, boolean[][] visited) {
        if (length == word.length()) {
            return true;
        }
        if (i < 0 || j <0 || i>=board.length || j >= board[0].length) return false;

        if (board[i][j] == word.charAt(length) && !visited[i][j]) {
            visited[i][j] = true;
            for (int[] dir:dirs) {
                if (backtrack(board,word,i+dir[0],j+dir[1],length+1,visited)){
                    return true;
                }
            }
            visited[i][j] = false;
        }

        return false;
    }

    public boolean exist2021(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,word.toCharArray(),i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] cs, int r, int c, int index, boolean[][] visited) {
        if (index == cs.length){
            return true;
        }
        if (r<0 || c <0 || r>=board.length || c>=board[0].length) return false;
        if (visited[r][c]) return false;


        visited[r][c] = true;
        if (board[r][c] == cs[index]){
            for (int dir[]:dirs) {
                if (dfs(board,cs,r+dir[0],c+dir[1],index+1,visited)){
                    return true;
                }
            }
        }
        visited[r][c] = false;
        return false;
    }
}
