package Question.leetcode;

/**
 * Created by gump on 2021/7/11.
 */
public class Q35 {

    public static void main(String[] args) {
        Q35 q = new Q35();
        int[] nums = {1,3};

        System.out.println(q.searchInsert(nums,2));
    }



    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        int mid = (l+r)/2;

        if (nums[mid] == target) {
            return mid;
        }

        if (target< nums[l]) {
            return l;
        }

        if (target> nums[r]) {
            return r+1;
        }

        if (nums[mid] > target){
            return binarySearch(nums,l,mid-1,target);
        }else {
            return binarySearch(nums,mid+1,r,target);
        }
    }
}
