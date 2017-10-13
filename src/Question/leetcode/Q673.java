package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/9/18.
 */
public class Q673 {


    public static void main(String argc[]){
        int input[] = {1,2,3,1,2,3,1,2,3};
        System.out.println(findNumberOfLIS(input));
    }


    public static int findNumberOfLIS(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int n = nums.length;
        int dp[] = new int[n];
        int dpLen[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dpLen,1);

        int result_dp = 1;
        int result_len = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if (dp[i] > max){
                        max = dp[i];
                        dpLen[i] = dpLen[j];
                    }else if(dp[j]+1 == max){
                        dpLen[i]+= dpLen[j];
                    }
                }
            }

            if (dp[i] > result_dp){
                result_dp = dp[i];
                result_len = dpLen[i];
            }else if (dp[i] == result_dp){
                result_len += dpLen[i];
            }
        }
        return result_len;
    }
}
