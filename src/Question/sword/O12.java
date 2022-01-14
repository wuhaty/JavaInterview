package Question.sword;

public class O12 {
    int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char cs[] = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board,i,j,n,m,cs,0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int n, int m, char[] cs, int index) {
        if (index == cs.length) return true;
        if (!(i>=0 && i<n && j>=0 && j<m)
                || (cs[index] != board[i][j])) return false;

        board[i][j] = '0';
        for (int[] dir:dirs) {
            int x = i +dir[0];
            int y = j +dir[1];

            if (dfs(board,x,y,n,m,cs,index+1)) {
                return true;
            }
        }
        board[i][j] = cs[index];

        return false;
    }
}
