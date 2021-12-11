package Question.leetcode;

public class Q303_2021_2 {

    int sum[];

    public Q303_2021_2(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = (sum[i-1]+nums[i]);
        }
    }

    public int sumRange(int left, int right) {
        return left==0? sum[right]:sum[right]-sum[left-1];
    }
}
