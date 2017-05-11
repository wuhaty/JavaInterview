package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q221 {

    public int maximalSquare(char[][] matrix) {
        if(matrix ==null || matrix.length==0) return 0;
        int max =0;
        int dp[][]= new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] - '0';
                if(dp[i][j]>0) max=1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(dp[i][j]==1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return (int)Math.pow(max,2);
    }
}
