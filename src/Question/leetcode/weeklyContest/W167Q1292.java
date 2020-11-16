package Question.leetcode.weeklyContest;

public class W167Q1292 {

    public static void main(String args[]){

        W167Q1292 q = new W167Q1292();
        int t[][] = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        q.maxSideLength(t,4);
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int max = 0;
        int dp[][] = new int[mat.length][mat[0].length];

        dp[0][0] = mat[0][0];
        for (int i = 1; i < mat.length; i++) {
            dp[i][0] = dp[i-1][0] + mat[i][0];
        }

        for (int j = 1; j < mat[0].length; j++) {
            dp[0][j] = dp[0][j-1] + mat[0][j];
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                max = Math.max(max,calculate(mat,i,j,threshold,dp));

            }
        }
        return max;
    }

    private int calculate(int[][] mat, int i, int j, int threshold, int[][] dp) {
        int s = 0;
        int max = 0;
        while ((i+s)<mat.length && (j+s)<mat[0].length){
            int s0=0,s1=0,s2=0;

            if (i-1 >=0 && j-1 >= 0)  s0 = dp[i-1][j-1];
            if (i-1 >=0) s1 = dp[i-1][j+s];
            if (j-1 >=0) s2 = dp[i+s][j-1];

            int size = (dp[i+s][j+s] - s1-s2+s0);
            if (size<=threshold) max = Math.max(max,s+1);
            s++;
        }

        return max;
    }
}
