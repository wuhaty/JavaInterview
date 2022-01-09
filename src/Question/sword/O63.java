package Question.sword;

public class O63 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int price:prices) {
            minPrice = Math.min(price,minPrice);
            maxProfile = Math.max(maxProfile,price - minPrice);
        }
        return maxProfile;
    }
}
