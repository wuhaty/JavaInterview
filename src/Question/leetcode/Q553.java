package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/11.
 */
public class Q553 {
    public String optimalDivision(int[] nums) {
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        sb.append(nums[nums.length-1]).append("/(");
        for (int i = nums.length-2; i >=0 ; i--) {
            if(i == nums.length-2){
                sb.append(String.valueOf(nums[i]));
            }else {
                sb.append("/").append(String.valueOf(nums[i]));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
