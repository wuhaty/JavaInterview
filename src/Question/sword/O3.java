package Question.sword;

import java.util.Arrays;

public class O3 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return -1;
    }

    public int findRepeatNumberOpt(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (k<0) k += n;
            if (nums[k] < 0) return nums[i];
            nums[i]-=n;
        }
        return -1;
    }
}
