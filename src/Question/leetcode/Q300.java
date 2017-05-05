package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/5.
 */
public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length ==0 )return 0;

        int dp[] =new int[nums.length];
        Arrays.fill(dp,1);
        int result = 1;

        for(int i =1;i<nums.length;i++){
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(dp[i],result);
        }
        return result;
    }

    public int BestlengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
