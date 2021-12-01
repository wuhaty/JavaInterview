package Question.leetcode;

public class Q189 {

    public void rotateTLE(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        while (k > 0) {
            int t = nums[n-1];

            for (int i = n-1; i >= 1; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = t;
            k--;
        }
    }


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l <r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }

}
