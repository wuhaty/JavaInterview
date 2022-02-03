package Question.mspractice;

public class M64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;

                int up = i>0 ? grid[i-1][j]:Integer.MAX_VALUE;
                int left = j>0 ? grid[i][j-1]:Integer.MAX_VALUE;
                grid[i][j] = Math.min(up,left) + grid[i][j];
            }
        }

        return grid[n-1][m-1];
    }
}
