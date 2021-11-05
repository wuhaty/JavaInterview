package Question.leetcode;

public class Q121_2 {

    public int maxProfit(int[] prices) {
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i-1],buy[i-1] + prices[i]);
            buy[i] = Math.max(buy[i-1],-prices[i]);
        }

        return sell[prices.length-1];
    }
}
