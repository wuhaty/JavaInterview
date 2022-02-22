package Question.leetcode.book.interviewSummary;

public class I334 {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second){
                return true;
            }else if(nums[i] > first) {
                second = nums[i];
            }else {
                first = nums[i];
            }
        }
        return false;
    }
}
