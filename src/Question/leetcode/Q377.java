package Question.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by gump on 2017/4/15.
 */
public class Q377 {
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int dp[][] = new int[nums.length+1][target+1];
        dp[0][0] = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]][nums[i]] = 1;
        }
        
        int sum= 0;
        for(int i = nums.length ; i>=1 ; i-- ){
            for (int j = nums[i-1]; j <= target; j++) {
                int count =0;
                for (int k = 0; k <= nums.length; k++) {
                    count += dp[k][j-nums[i-1]];
                }
                dp[i][j] = count;
            }
        }

        for (int i = 0; i <= nums.length; i++) {
            sum+= dp[i][target];
        }

        return sum;
    }

    public static void main(String argc[]){
        int test[] = {1,3,5};

       System.out.println(combinationSum4(test,5));
    }
}
