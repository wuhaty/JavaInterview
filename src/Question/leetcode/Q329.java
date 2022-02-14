package Question.leetcode;

public class Q329 {
    Integer[][] dp;
    int[][] dirs = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new Integer[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = dfs(matrix,i,j);
                ans = Math.max(ans,t);
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != null) return dp[i][j];

        int length = 0;
        for (int[] dir:dirs) {
            int x = i + dir[0];
            int y = j + dir[1];


            if (x>=0 && y >=0 && x<matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]){
                length = Math.max(length, 1 + dfs(matrix,i,j));
            }
        }

        dp[i][j] = length;
        return length;
    }
}
