package Question.leetcode;

public class Q714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;

        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        buy[0] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
            buy[i] = Math.max(buy[i-1],sell[i]-prices[i]);
        }

        return Math.max(sell[prices.length-1],0);
    }

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int buy[] = new int[n];
        int sell[] = new int[n];

        buy[0] = -prices[0];
        int maxbuy = -prices[0];
        int maxsell = 0;

        for (int i = 1; i < n; i++) {
            int tempbuy = maxbuy;
            buy[i] = maxsell-prices[i];
            maxbuy = Math.max(buy[i],maxbuy);
            sell[i] = tempbuy+prices[i]-fee;
            maxsell = Math.max(sell[i],maxsell);
        }
        return maxsell;
    }
}
