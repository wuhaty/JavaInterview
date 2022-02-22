package Question.mspractice;

public class M887_2 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];

        for (int i = 1; i <= N; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 0;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
//                int tMinDrop = n * n;
//                for (int x = 1; x <= n; x++) {
//                    tMinDrop = Math.min(tMinDrop,1 + Math.max(dp[k-1][x-1],dp[k][n-x]));
//                }

                int l = 1 , r = n;
                while (l<r){
                    int mid = l + (r-l+1)/2;

                    int eggBreak = dp[k-1][mid-1];
                    int eggNotBreak = dp[k][n-mid];

                    if (eggBreak > eggNotBreak){
                        r = mid - 1;
                    }else {
                        l = mid;
                    }
                }
                dp[k][n] = Math.max(dp[k-1][l-1],dp[k][n-l])+1;
            }
        }

        return dp[K][N];
    }
}
