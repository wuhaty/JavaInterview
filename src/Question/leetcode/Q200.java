package Question.leetcode;

/**
 * Created by gump on 2021/6/8.
 */
public class Q200 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                }

                dfs(grid,i,j,n,m);
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j,int n ,int m) {
        if (i<0 || j<0 || i>=n || j>=m || grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfs(grid,i-1,j,n,m);
        dfs(grid,i+1,j,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i,j+1,n,m);
    }

    int count = 0;

    public static void main(String[] args) {
        Q200 q = new Q200();
        char[][] a= {
            {'1','1','0'},
            {'1','0','0'}
        };
        q.numIslands2021(a);
    }

    public int numIslands2021(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    dfs2021(grid,i,j,n,m);
                }
            }
        }

        return count;
    }

    private void dfs2021(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i>=n || j<0 || j >= m) return;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs2021(grid,i-1,j,n,m);
            dfs2021(grid,i+1,j,n,m);
            dfs2021(grid,i,j-1,n,m);
            dfs2021(grid,i,j+1,n,m);
        }
    }
}
