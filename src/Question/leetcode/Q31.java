package Question.leetcode;

public class Q31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length -2;

        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if (i >= 0) {
            int j = nums.length -1;
            while (j>=0 && nums[i]>nums[j]){
                j--;
            }

            swap(nums,i,j);
        }

        reverse(i+1,nums);
    }

    private void reverse(int i, int[] nums) {
        int s = i , e = nums.length-1;

        while (s<e){
            swap(nums,s,e);
            s++;
            e--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
