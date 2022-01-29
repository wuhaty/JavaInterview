package Question.mspractice;

public class M34 {

    public static void main(String[] args) {
        M34 m = new M34();
//        m.searchRange(new int[]{5,7,7,8,8,10},8);
        m.searchRange(new int[]{2,2},2);
    }


    public int[] searchRange(int[] nums, int target) {
        int l =0, r= nums.length-1;
        if (nums.length==0 || target<nums[l] || target > nums[r]) return new int[]{-1,-1};

        int lowerIndex = binarySearch(nums,target,true);
        if (nums[lowerIndex] != target) return new int[]{-1,-1};
        int higherIndex = binarySearch(nums,target,false)-1;

        if (lowerIndex<=higherIndex && higherIndex<nums.length && nums[lowerIndex] == target && nums[higherIndex] == target){
            return new int[]{lowerIndex,higherIndex};
        }

        return new int[]{-1,-1};
    }

    private int binarySearch(int[] nums, int target, boolean isEqual) {
        //isEqual = true , search first element >= target
        //isEqual = false , search first element > target
        int l = 0 , r = nums.length - 1, ans = nums.length;

        while (l<=r){
            int mid = l + (r-l)/2;

            if (nums[mid] > target || (isEqual && nums[mid] >=target)){
                ans = mid;
                r = mid -1;
            }else {
                l = mid +1;
            }
        }

        return ans;
    }
}
