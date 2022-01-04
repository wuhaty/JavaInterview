package Question.sword;

public class O53_2 {
    public int missingNumber(int[] nums) {
        int l = 0 , r = nums.length;
        while (l<r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == mid) {
                l = mid+1;
            }else {
                r = mid;
            }
        }

        return r;
    }
}
