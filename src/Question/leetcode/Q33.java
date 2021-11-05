package Question.leetcode;

/**
 * Created by gump on 2021/6/27.
 */
public class Q33 {

    public static void main(String[] args) {
        Q33 q = new Q33();
        int[] n = {4,5,6,7,0,1,2};
        q.search(n,3);
    }

    // mid = (l+r)/2 will always be >= l, so should leave the equals condition to the lower side.
    public int search(int[] nums, int target) {
        int l = 0, r= nums.length-1;

        while (l<=r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid]>=nums[l]) {
                //left in order
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid -1;
                }else{
                    l = mid + 1;
                }

            }else{
                //right in order
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }
}
