package Question.leetcode;

public class Q1822 {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            if (nums[i] < 0) res = (-res);
        }
        return res;
    }
}
