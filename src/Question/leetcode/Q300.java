package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/5.
 */
public class Q300 {

    public static void main(String[] args) {
        Q300 q = new Q300();
        int n[] = {0,1,0,3,2,3};
        q.lengthOfLIS2021(n);
    }

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

    public int lengthOfLIS2021(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }

        return max;
    }

    public int lengthOfLISBinarySearch(int[] nums) {
        int l = nums.length;
        int len = 1;
        int res[] = new int[l];
        res[0] = nums[0];

        for (int i = 1; i < l; i++) {
            int n = nums[i];
            if (n>res[len-1]){
                res[len++] = n;
            }else if (n < res[len-1]){
                int index = Arrays.binarySearch(res,0,len-1,n);
                if (index == -1) continue;
                res[index] = n;
            }
        }

        return len;
    }
}
