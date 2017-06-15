package Question.leetcode;

/**
 * Created by gump on 2017/5/31.
 */
public class Q121 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;

        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit,prices[i] - buy);
            buy = Math.min(buy,prices[i]);
        }
        return profit;
    }
}
