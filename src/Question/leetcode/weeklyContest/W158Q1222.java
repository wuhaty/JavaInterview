package Question.leetcode.weeklyContest;

import java.util.List;

public class W158Q1222 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int lu[] = null;
        int l[] = null;
        int ld[] = null;
        int d[] = null;
        int rd[] = null;
        int r[] = null;
        int ru[] = null;
        int u[] = null;

        for (int[] queen : queens) {
            int xdiff = queen[0] - king[0];
            int ydiff = queen[1] - king[1];

            if (xdiff == 0 || ydiff == 0) {
                if (xdiff > 0){

                }else if (xdiff < 0){

                }else if (ydiff > 0){

                }else if (ydiff < 0){

                    
                }
            } else {

                if (Math.abs(xdiff) - Math.abs(ydiff) == 0) {
                    if (xdiff > 0) {
                        if (rd == null) {
                            rd = queen;
                            continue;
                        }

                        int gap = Math.abs(rd[0] - king[0]);
                        int t = Math.min(Math.abs(xdiff), gap);
                        if (t < gap) {
                            rd = queen;
                        }
                    } else {
                        if (lu == null) {
                            lu = queen;
                            continue;
                        }

                        int gap = Math.abs(lu[0] - king[0]);
                        int t = Math.min(Math.abs(xdiff), gap);
                        if (t < gap) {
                            lu = queen;
                        }
                    }
                }

                if (Math.abs(xdiff) - Math.abs(ydiff) == 2) {
                    if (ydiff > 0) {
                        if (ru == null) {
                            ru = queen;
                            continue;
                        }

                        int gap = Math.abs(ru[0] - king[0]);
                        int t = Math.min(Math.abs(xdiff), gap);
                        if (t < gap) {
                            ru = queen;
                        }
                    } else {
                        if (ld == null) {
                            ld = queen;
                            continue;
                        }

                        int gap = Math.abs(ld[0] - king[0]);
                        int t = Math.min(Math.abs(xdiff), gap);
                        if (t < gap) {
                            ld = queen;
                        }
                    }
                }
            }
        }
        return null;
    }
}
