package Question.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by gump on 2017/4/17.
 */
public class Q322 {
    public static int coinChange(int[] coins, int amount) {
        if(amount ==0 ) return 0;
        int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);

        dp[0] = 0;
        for(int j = 1;j<=amount;j++){
            for(int i =0;i<coins.length;i++){
                if(coins[i] > j){
                    continue;
                }
                if(dp[j]!=-1 && dp[j-coins[i]]!=-1){
                    dp[j] = Math.min(dp[j],1+dp[j-coins[i]]);
                }else if(dp[j]==-1 && dp[j-coins[i]]!=-1){
                    dp[j] = 1+dp[j-coins[i]];
                }

            }
        }
        return dp[amount];
    }

    public static void main(String argc[]){
        int[] a = {1};
        int b =1;
        System.out.println(coinChange(a,b));
    }
}
