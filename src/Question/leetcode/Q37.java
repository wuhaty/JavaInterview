package Question.leetcode;

/**
 * Created by gump on 2021/7/10.
 */
public class Q37 {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (valid(board,i,j,k)){
                            board[i][j] = k;

                            if (solve(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int i, int j, char k) {
        //row
        for (int l = 0; l < 9; l++) {
            if (board[i][l] == k) return false;
        }

        //col
        for (int l = 0; l < 9; l++) {
            if (board[l][j] == k) return false;
        }

        //mat
        for (int l = 0; l < 9; l++) {
            if (board[3*(i/3)+l/3][3*(j/3)+l%3] == k) return false;
        }

        return true;
    }
}
