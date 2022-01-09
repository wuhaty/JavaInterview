package Question.sword;

public class O47 {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int j = 1; j < m; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[n-1][m-1];
    }
}
