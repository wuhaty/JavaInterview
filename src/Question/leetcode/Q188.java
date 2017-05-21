package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/19.
 */
public class Q188 {

    public static void main(String argc[]) {
        Q188 q = new Q188();
        int prices[] = {3, 10, 0, 9, 5, 6};
        q.maxProfit(2, prices);
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= (prices.length / 2)) return quickSolve(prices);
        int dp[][] = new int[k+1][n];


        for (int i = 1; i <= k ; i++) {
            int localMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],prices[j]+localMax);
                localMax = Math.max(localMax,dp[i-1][j-1] -prices[j]);
            }
        }
        return dp[k][n-1];
    }

    public int maxProfitOri(int k, int[] prices) {
        int h[] = new int[k];
        int r[] = new int[k];
        if (k >= (prices.length / 2)) return quickSolve(prices);
        Arrays.fill(h, Integer.MIN_VALUE);
        Arrays.fill(r, 0);


        for (int i = 0; i < prices.length; i++) {

            for (int j = k - 1; j >= 0; j--) {
                if (j == 0) {
                    r[j] = Math.max(r[j], h[j] + prices[i]);
                    h[j] = Math.max(h[j], -prices[i]);
                } else {
                    r[j] = Math.max(r[j], h[j] + prices[i]);
                    h[j] = Math.max(h[j], r[j - 1] - prices[i]);
                }
            }
        }
        return r[k - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
