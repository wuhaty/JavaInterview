package Question.leetcode;

public class Q287 {

    public int findDuplicateTricky(int[] nums) {
        boolean[] h = new boolean[Integer.MAX_VALUE];

        for (int i = 0; i < nums.length; i++) {
            if (h[i]) return nums[i];
            else h[i]=true;
        }

        return -1;
    }

    public int findDuplicate(int[] nums) {
        int l = 0,n = nums.length, r= n-1;
        int ans = -1;
        while (l<r) {
            int mid = (l+r)/2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i]<=mid){
                    count++;
                }
            }

            if (count<=mid){
                l = mid+1;
            }else {
                r = mid -1;
                ans = mid;
            }
        }
        return ans;
    }
}
