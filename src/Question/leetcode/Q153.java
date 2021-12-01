package Question.leetcode;

public class Q153 {
    public int findMin(int[] nums) {
        int l =0,r = nums.length-1;

        while (l<r){
            int mid = (l+r)/2;

            if (nums[r] > nums[mid]){
                //right increasing
                r = mid;
            }else if (nums[r]<= nums[mid]){
                //left increasing
                l = mid+1;
            }
        }

        return nums[l];
    }
}
