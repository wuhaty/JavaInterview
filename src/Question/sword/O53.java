package Question.sword;

public class O53 {
    public static void main(String[] args) {
        O53 q = new O53();
        int[] nums = new int[]{5,7,7,8,8,10};
        q.search(nums,8);
    }



    public int search(int[] nums, int target) {
        return binarySearch(nums,target+1) - binarySearch(nums,target);
    }

    private int binarySearch(int[] nums, int target) {
        int l =0,r=nums.length-1;

        while (l<r){
            int mid = l + (r-l)/2;
            if (nums[mid]>=target) {
                r = mid;
            }else {
                l= mid+1;
            }
        }
        return r;
    }
}
