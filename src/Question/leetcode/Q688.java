package Question.leetcode;

public class Q688 {

    int dirs[][] = {
            {-2,1},
            {-1,2},
            {1,2},
            {2,1},
            {2,-1},
            {1,-2},
            {-1,-2},
            {-2,-1}
    };
    int dp[][];
    int currAttempt = 0;

    public static void main(String[] args) {
        Q688 q = new Q688();
        q.knightProbabilityTLE(3,2,0,0);
    }

    public double knightProbabilityTLE(int n, int k, int row, int column) {
        if (k==0) return 1.0;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir:dirs) {
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if (x>=0 && x<n && y >=0 && y<n) dp[i][j]++;
                }
            }
        }

        dfs(row,column,n,0,k);

        return currAttempt/Math.pow(8,k);
    }

    public double knightProbability(int n, int k, int row, int column){
        double dp2[][] = new double[n][n];

        dp2[row][column] = 1;

        for (; k >0 ; k--) {
            double[][] dt = new double[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int dir[]:dirs) {
                        int dx = x+dir[0];
                        int dy = y+dir[1];
                        if (dx>=0 && dx<n && dy>=0 && dy<n){
                            dt[dx][dy] += dp2[x][y]/8.0;
                        }
                    }
                }
            }
            dp2 = dt;
        }

        double sum = 0.0;
        for (double[] r:dp2) {
            for (double d:r) {
                sum+=d;
            }
        }
        return sum;
    }

    private void dfs(int row, int column, int n,int round,int k) {
        if (row<0 || row>=n || column <0 || column>=n) return;
        if (round ==(k-1)) {
            currAttempt += dp[row][column];
            return;
        }

        for (int[] dir:dirs) {
            dfs(row+dir[0],column+dir[1],n,round+1,k);
        }
    }
}
