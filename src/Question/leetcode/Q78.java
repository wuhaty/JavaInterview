package Question.leetcode;

/**
 * Created by gump on 2021/7/10.
 */
public class Q78 {
    public static void main(String[] args) {
        char[][] b = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };

        Q78 q = new Q78();
        q.exist(b,"SEE");
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, String word, int i, int j, int index,boolean[][] visited) {
        if (i<0 || i>=board.length || j<0 || j>board[0].length) return false;
        if (index >= word.length()) return true;

        if (!visited[i][j] && board[i][j] == word.charAt(index)) {
            visited[i][j] = true;

            boolean result = (check(board,word,i-1,j,index+1,visited)
                    || check(board,word,i+1,j,index+1,visited)
                    || check(board,word,i,j-1,index+1,visited)
                    || check(board,word,i,j+1,index+1,visited));
            if (result){
                return true;
            }else {
                visited[i][j] = false;
            }
        }
        return false;
    }
}
