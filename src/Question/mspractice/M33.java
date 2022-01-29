package Question.mspractice;

public class M33 {

    public static void main(String[] args) {
        M33 m = new M33();
        m.search(new int[]{4,5,6,7,0,1,2},0);
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;

        while (l<=r) {
            int mid = (l + r) >>1;
            if (nums[mid] == target) return mid;

            if (nums[0]<= nums[mid]){
                if (nums[0] <= target && target< nums[mid]){
                    r = mid-1;
                }else {
                    l = mid +1;
                }
            }else {
                if (nums[mid]<target && target<= nums[nums.length-1]){
                    l = mid +1;
                }else {
                    r = mid-1;
                }
            }

        }

        return -1;
    }
}
