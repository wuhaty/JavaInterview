package Question.mspractice.mock.d3;

import java.util.Arrays;

public class q3 {
    private static final int MOD = (int) (1e9 + 7);

    public int numWays(String[] words, String target) {
        int m = target.length();
        int w = words[0].length();
        int cnt[][] = new int[w][26];
        for (String word:words) {
            for (int i = 0; i < w; i++) {
                cnt[i][word.charAt(i)-'a']++;
            }
        }

        long dp[][] = new long[w][m];
        for (long[] d:dp) {
            Arrays.fill(d,-1);
        }
        return (int) dfs(cnt,dp,0,0,w,m,target);
    }

    private long dfs(int[][] cnt, long[][] dp, int i, int j, int n, int m,String target) {
        if (j==m) return 1;
        if (n-i<m-j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        long val = cnt[i][target.charAt(j)-'a'] * dfs(cnt,dp,i+1,j+1,n,m,target);
        val += dfs(cnt,dp,i+1,j,n,m,target);
        val %= MOD;
        dp[i][j] = val;

        return val;
    }
}
