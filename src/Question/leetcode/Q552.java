package Question.leetcode;

/**
 * Created by gump on 2017/5/16.
 */
public class Q552 {
    int mod = 1000000007;

    public static void main(String argc[]) {
        Q552 q = new Q552();
        q.checkRecord(3);
    }

    public int checkRecord(int n) {
        int dp[][][] = new int[n + 1][2][3];

        dp[1] = new int[][]{{1, 1, 0},
                {1, 0, 0}};


        for (int k = 2; k <= n; k++) {
            dp[k][0][0] = sum(dp[k - 1][0]);
            dp[k][0][1] = dp[k - 1][0][0];
            dp[k][0][2] = dp[k - 1][0][1];
            dp[k][1][0] = sum(dp[k - 1][0]) + sum(dp[k - 1][1]) % mod;
            dp[k][1][1] = dp[k - 1][1][0];
            dp[k][1][2] = dp[k - 1][1][1];
        }
        return (sum(dp[n][0]) + sum(dp[n][1])) % mod;
    }

    private int sum(int[] ints) {
        long sum = 0;
        for (int i = 0; i < 3; i ++)
            sum+=ints[i];
        return (int)(sum % mod);
    }
}
