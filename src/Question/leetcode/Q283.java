package Question.leetcode;

public class Q283 {

    public void moveZeroesOri(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0){
                int j = i+1;
                while (j<n && nums[j] == 0) {
                    j++;
                }

                if (j == n) return;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }

    public void moveZeroesOpt(int[] nums) {
        int l = 0,r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != 0){
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
            }
            r++;
        }
    }

}
