package Question.leetcode.book.interviewSummary;

public class I189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l<r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;r--;
        }
    }
}
