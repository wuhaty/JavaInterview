package Question.leetcode.book.interviewSummary;

public class I283 {
    public void moveZeroes(int[] nums) {
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums,i,p++);
            }
        }
    }

    private void swap(int[] nums, int l,int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
