package Question.leetcode.book.interviewSummary;

public class I887 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];

        for (int i = 0; i <= K; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int l = 1, r = j;

                while (l<r){
                    int mid = l + (r-l+1)/2;

                    int eggBreak = dp[i-1][mid-1];
                    int eggNotBreak = dp[i][j-mid];

                    if (eggBreak<=eggNotBreak){
                        l = mid;
                    }else {
                        r = mid - 1;
                    }
                }

                dp[i][j] = Math.max(dp[i-1][l-1],dp[i][j-l])+1;
            }
        }

        return dp[K][N];
    }
}
