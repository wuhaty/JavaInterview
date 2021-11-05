package Question.leetcode;

/**
 * Created by gump on 2021/7/21.
 */
public class Q303_2021 {


    int[] sum = null;

    public Q303_2021(int[] nums) {
        sum = new int[nums.length];
        if (nums.length>0) {
            sum[0] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right]-((left==0)?0:sum[left-1]);
    }
}
