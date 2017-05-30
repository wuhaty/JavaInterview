package Question.classified.DP;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/28.
 */
public class LongestIncreasingSubsequence {

    public static void main(String argc[]){
        LongestIncreasingSubsequence q = new LongestIncreasingSubsequence();
        int data[] = {10,9,2,5,3,7,101,18};
        q.lengthOfLISBinary(data);
    }

    public int lengthOfLISBinary(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        // remark:dp[i] records the smallest end of increasing subsequence with length i
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
    }



    public int lengthOfLISDP(int[] nums) {
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
}
