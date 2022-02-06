package Question.mspractice.mock.d9;

public class q3 {
    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length-1;
        while (l<=r){
            int mid = l + (r-l)/2;

            if (nums[mid] == target) return mid;
            else if (nums[l]<=nums[mid]){
                //left increasing , (l+r)/2 向下取整, 只有l可能等于mid
                if (target>=nums[l] && target<nums[mid]){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                //right increasing
                if (target>nums[mid] && target<=nums[r]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }

        return -1;
    }
}
