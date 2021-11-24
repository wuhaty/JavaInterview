package Question.leetcode;

public class Q36 {

    public boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int dig[][] = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row[i][board[i][j]-'0'-1] ++;
                    col[j][board[i][j]-'0'-1] ++;
                    dig[3*(i/3)+j/3][board[i][j]-'0'-1] ++;
                    if (row[i][board[i][j]-'0'-1] > 1) return false;
                    if (col[j][board[i][j]-'0'-1] >1) return false;
                    if (dig[3*(i/3)+j/3][board[i][j]-'0'-1] > 1) return false;
                }
            }
        }
        return true;
    }
}
