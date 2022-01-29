package Question.mspractice;

public class M200 {

    int sum = 0;
    int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    sum++;
                    dfs(grid,i,j,n,m);
                }
            }
        }

        return sum;
    }

    private void dfs(char[][] grid, int i, int j,int n,int m) {
        if (i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid[i][j] == '0') return;

        visited[i][j] = true;

        for (int[] dir:dirs) {
            dfs(grid,i+dir[0],j+dir[1],n,m);
        }
    }
}
