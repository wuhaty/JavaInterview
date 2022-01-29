package Question.mspractice;

public class M121 {
    public int maxProfit(int[] prices) {
        int preLow = Integer.MAX_VALUE;
        int max = 0;

        for (int p:prices) {
            max = Math.max(max,p-preLow);
            preLow = Math.min(preLow,p);
        }

        return max;
    }
}
