package Question.leetcode;

/**
 * Created by gump on 2021/7/21.
 */
public class Q53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxEnd = nums[0];


        for (int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(nums[i],maxEnd+nums[i]);
            max = Math.max(maxEnd,max);
        }
        
        return max;
    }

    public int maxSubArray_2021(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            max = Math.max(pre,max);
        }

        return max;
    }
}
