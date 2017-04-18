package Question.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2017/4/13.
 */
public class Q416 {
    public static boolean canPartition(int[] nums) {
        int sum=0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if(sum%2!=0)return false;

        sum/=2;

        boolean dp[][] =new boolean[nums.length+1][sum+1];

        dp[0][0] =true;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < dp.length+1; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[nums.length][sum];
    }

    public static void main(String argc[]){
        int nums[] ={1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
