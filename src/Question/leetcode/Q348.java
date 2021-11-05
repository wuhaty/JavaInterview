package Question.leetcode;

/**
 * Created by gump on 2021/7/24.
 */
public class Q348 {

//    int m[][] = null;
//
//    public Q348(int n) {
//        m = new int[n][n];
//    }

//    public int move(int row, int col, int player) {
//        m[row][col] = player;
//
//        for (int i = 0; i < m.length; i++) {
//            int count = 0;
//            for (int j = 0; j < m.length; j++) {
//                if (m[i][j] == player) {
//                    count ++;
//                }else {
//                    break;
//                }
//            }
//            if (count == m.length) return player;
//        }
//
//
//        for (int j = 0; j < m.length; j++) {
//            int count = 0;
//            for (int i = 0; i < m.length; i++) {
//                if (m[i][j] == player) {
//                    count ++;
//                }else {
//                    break;
//                }
//            }
//            if (count == m.length) return player;
//        }
//
//        int count = 0;
//        for (int i = 0; i < m.length; i++) {
//            if (m[i][i] ==player){
//                count ++;
//            }else {
//                break;
//            }
//        }
//        if (count == m.length) return player;
//        count=0;
//        for (int i = 0; i < m.length; i++) {
//            if (m[i][m.length-i-1] ==player){
//                count ++;
//            }else {
//                break;
//            }
//        }
//        if (count == m.length) return player;
//        return 0;
//    }

    int row[] = null;
    int col[] = null;
    int x = 0;
    int y = 0;


    public Q348(int n) {
        row = new int[n];
        col = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int r, int c, int player) {
        int decision = player==1?1:-1;
        int n = row.length;
        row[r] += decision;
        col[c] += decision;
        if (r==c) x += decision;
        if ((r+c) == (n-1)) y += decision;

        if (Math.abs(row[r]) == n || Math.abs(col[c]) == n || Math.abs(x) == n || Math.abs(y) == n) {
            return player;
        }
        return 0;
    }
}
