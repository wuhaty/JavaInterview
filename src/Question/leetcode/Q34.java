package Question.leetcode;

public class Q34 {

    public static void main(String[] args) {
        Q34 q = new Q34();

        q.searchRange(new int[]{5,7,7,8,8,10},8);
    }


    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target,0,nums.length-1,false);
        if (left >= nums.length || nums[left] != target) return new int[]{-1,-1};
        int right = binarySearch(nums,target,0,nums.length-1,true);
        return new int[]{left,right-1};
    }

    private int binarySearch(int[] nums, int target, int l, int r, boolean isLarger) {
        while (l<r){
            int mid = l + (r-l)/2;

            if (target>nums[mid] || (isLarger && target>=nums[mid])){
                l = mid +1;
            }else {
                r = mid;
            }
        }

        return l;
    }

    public int[] searchRange2(int[] nums, int target) {
        /**
         * lower_bound 求满足某个条件的最小值
         * bsearch_1 求满足某个条件的最小值
         * up_bound 求大于某个条件（值）的最小值
         * bsearch_2 求满足某个条件的最大值
         **/

        int l = 0, r = nums.length-1;

        while (l<r){
            int mid = (l + r)/2;

            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid +1;
            }
        }
        if (nums[l] != target) return new int[]{-1,-1};

        int left = l;
        l = 0; r = nums.length-1;

        while (l<r){
            int mid = (l+r+1)/2;

            if (nums[mid] <=target){
                l = mid;
            }else {
                r = mid -1;
            }
        }
        return new int[]{left,l};
    }
}
