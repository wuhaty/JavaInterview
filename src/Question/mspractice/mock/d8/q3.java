package Question.mspractice.mock.d8;

import java.util.Arrays;

public class q3 {
    int[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new int[n][fuel +1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }

        return dfs(locations,start,finish,fuel);
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        if (dp[start][fuel] != -1) return dp[start][fuel];
        if (fuel < Math.abs(locations[start]-locations[finish])) return 0;
        int sum = start == finish? 1:0;


        for (int i = 0; i < locations.length; i++) {
            if (i==start) continue;
            int cost = Math.abs(locations[start] - locations[i]);
            if (fuel>= cost){
                sum+= dfs(locations,i,finish,fuel-cost);
                sum%=1000000007;
            }
        }

        dp[start][fuel] = sum;
        return sum;
    }

    public int countRoutesDP(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new int[n][fuel+1];

        for (int i = 0; i <= fuel; i++) {
            dp[finish][i] = 1;
        }

        for (int k = 0; k <= fuel; k++) {
            for (int i = 0; i < n; i++) {
                int need = Math.abs(locations[i]-locations[finish]);
                if (need > k) {
                    continue;
                }

                for (int j = 0; j < n; j++) {
                    if (i!=j){
                        int cost = Math.abs(locations[j]-locations[i]);
                        if (k>= cost){
                            //dp[i][fuel] = dp[i][fuel] + dp[j][fuel-cost];
                            dp[i][k]+=dp[j][k-cost];
                            dp[i][k] %= 1000000007;
                        }
                    }
                }
            }
        }

        return dp[start][fuel];
    }
}
