package Question.leetcode;

/**
 * Created by gump on 2017/12/20.
 */
public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int right = nums[n-1];
        for (int i = n-2; i >=0 ; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
}