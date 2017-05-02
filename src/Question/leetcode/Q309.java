package Question.leetcode;

/**
 * Created by gump on 2017/4/24.
 */
public class Q309 {
    public int maxProfit(int[] prices) {

        if(prices== null || prices.length<2) return 0;

        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0],-prices[1]);
        sell[1] = Math.max(prices[1]-prices[0],0);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
        }

        return sell[prices.length-1];
    }

    public static void main(String argc[]){
        Q309 q = new Q309();
        int d[] = {1,2,3,0,2};
        System.out.println(q.maxProfit(d));
    }
}
