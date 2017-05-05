package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/4.
 */
public class Q164 {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        int maxDiffer = 0;
        for (int i = 1; i < nums.length; i++) {
            maxDiffer = Math.max(maxDiffer,Math.abs(nums[i]-nums[i-1]));
        }
        return maxDiffer;
    }
}
