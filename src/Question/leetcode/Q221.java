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

    public int maximalSquare2021(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int max = 0;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
            max = Math.max(dp[i][0],max);
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
            max = Math.max(dp[0][j],max);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                    max = Math.max(max,dp[i][j] * dp[i][j]);
                }
            }
        }

        return max;
    }
}
