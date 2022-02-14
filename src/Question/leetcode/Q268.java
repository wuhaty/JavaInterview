package Question.leetcode;

public class Q268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = (n*(n+1))/2;
        int sum = 0;

        for (int i:nums) {
            sum += i;
        }

        return expected - sum;
    }
}
