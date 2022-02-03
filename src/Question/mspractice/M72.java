package Question.mspractice;

public class M72 {
    public int minDistanceOpt(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0 || m == 0) return Math.max(n,m);

        int[] dp = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= m; j++) {
                int cur = dp[j];

                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = prev;
                }else {
                    dp[j] = Math.min(Math.min(dp[j],dp[j-1]),prev) +1;
                }
                prev = cur;
            }
        }

        return dp[m];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n == 0 || m == 0) return Math.max(n,m);

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j-1] +1;
                int up = dp[i-1][j] +1;
                int upLeft = dp[i-1][j-1];

                if (word1.charAt(i-1) != word2.charAt(j-1)){
                    upLeft++;
                }

                dp[i][j] = Math.min(upLeft,Math.min(left,up));
            }
        }

        return dp[n][m];
    }
}
