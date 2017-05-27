package Question.classified.DP;

/**
 * Created by gump on 2017/5/18.
 */
public class KadaneAlg {
    public static int findMaxSubArray(int[] nums){
        int dp[] = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
