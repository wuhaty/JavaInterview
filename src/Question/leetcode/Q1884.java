package Question.leetcode;

public class Q1884 {
    public int twoEggDrop(int n) {
        Integer[][] dp = new Integer[n+1][3];

        return helper(n,2,dp);
    }

    private int helper(int n, int k, Integer[][] dp) {
        if (n==0) return 0;
        if (k == 1) return n;

        if (dp[n][k] != null) return dp[n][k];

        int res = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            res = Math.min(res, 1 + Math.max(helper(n-i,k,dp),helper(i-1,k-1,dp)));
        }

        dp[n][k] = res;
        return res;
    }
}
