package Question.leetcode;

/**
 * Created by gump on 2017/5/11.
 */
public class Q122 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) profit += (prices[i]-prices[i-1]);
        }
        return profit;
    }
}
