package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2017/10/13.
 */
public class W53Q695 {


    public static void main(String argc[]) {
        W53Q695 q = new W53Q695();
        int d[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(q.maxAreaOfIsland(d));
    }


    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = Math.max(count, dfs(i, j, m, n, grid, visited, 0));
            }
        }
        return count;
    }

    private int dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited, int count) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == 0) return 0;

        visited[i][j] = true;
        count += 1;
        count += dfs(i + 1, j, m, n, grid, visited, 0);
        count += dfs(i - 1, j, m, n, grid, visited, 0);
        count += dfs(i, j + 1, m, n, grid, visited, 0);
        count += dfs(i, j - 1, m, n, grid, visited, 0);

        return count;
    }
}
