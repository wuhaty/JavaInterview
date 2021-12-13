package Question.leetcode;

public class Q1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n+1][m+1][2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i-1][j-1] == 0){
                    continue;
                }
                dp[i][j][0] = dp[i][j-1][0] +1;
                dp[i][j][1] = dp[i-1][j][1] +1;
            }
        }

        int max=0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                int curSide = Math.min(dp[i][j][0],dp[i][j][1]);

                if (curSide < max){
                    continue;
                }

                for (; curSide > max; curSide--) {
                    if (dp[i-curSide+1][j][0]>= curSide &&dp[i][j-curSide+1][1]>=curSide){
                        max = curSide;
                        break;
                    }
                }
            }
        }

        return max*max;
    }
}
