package Question.leetcode.book.interviewSummary;

public class I169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) count++;
            else count--;
            if (count ==0) {
                count++;
                max = nums[i];
            }
        }

        return max;
    }
}
