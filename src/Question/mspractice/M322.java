package Question.mspractice;

import java.util.Arrays;

public class M322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount);

        dp[0] = 0;

        for (int i = 1; i <=amount ; i++) {
            for (int j = coins.length-1; j >=0; j--) {
                if (i-coins[j] >=0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] +1);
                }
            }
        }

        return dp[amount] > amount?-1:dp[amount];
    }
}
