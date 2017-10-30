package Question.leetcode;

/**
 * Created by gump on 2017/10/30.
 */
public class Q714 {
    public static void main(String argc[]){
        Q714 q = new Q714();
        int prices[] = {1, 3, 2, 8, 4, 9};
        q.maxProfit(prices,2);
    }

    public int maxProfit(int[] prices, int fee) {
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
