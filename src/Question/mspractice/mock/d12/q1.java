package Question.mspractice.mock.d12;

public class q1 {
    public void moveZeroes(int[] nums) {
        int l = 0 , r = 0;

        while (r < nums.length){
            if (nums[r] ==0){
                swap(nums,l,r);
                l++;
            }
            r++;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
