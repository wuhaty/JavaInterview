package Question.sword;

public class O13 {
    int M = 0, N = 0, K = 0;
    int res =0;
    int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public int movingCount(int m, int n, int k) {
        M = m;
        N = n;
        K = k;
        boolean visited[][] = new boolean[m][n];
        dfs(0,0,visited);
        return res;
    }

    private void dfs(int i, int j, boolean[][] visited) {
        if (i<0 || i >= M || j <0 || j >= N || visited[i][j]) return;
        visited[i][j] = true;

        int sum = 0;
        int ii = i, jj =j;
        while (ii > 0){
            int t = ii % 10;
            ii /=10;
            sum+=t;
        }
        while (jj > 0){
            int t = jj % 10;
            jj /=10;
            sum+=t;
        }

        if (sum > K ) return;

        res++;
        for (int[] dir:dirs) {
            dfs(i+dir[0],j+dir[1],visited);
        }
        return;
    }
}
