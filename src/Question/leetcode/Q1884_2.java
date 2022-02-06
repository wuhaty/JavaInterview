package Question.leetcode;

public class Q1884_2 {
    Integer[][] dp;

    public int twoEggDrop(int n) {
        dp = new Integer[n+1][3];

        for (int i = 1; i <=n ; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }
        helper(n,2);
        return dp[n][2];
    }

    private int helper(int n, int i) {
        if (dp[n][i] != null) return dp[n][i];

        int min = n;
        for (int j = 1; j <= n; j++) {
            min = Math.min(min, 1 + Math.max(helper(j-1,i-1),helper(n-j,i)));
        }

        dp[n][i] = min;
        return min;
    }

    public int twoEggDropMath(int n) {
        //https://www.bilibili.com/video/BV1KE41137PK
        //2 eggs , to minimize the result , the search range should be reduced at each attempt
        //1 + 2 + 3 + .. x >= n
        return (int) Math.ceil((-1.+Math.sqrt(1+8*n))/2.);
    }
}
