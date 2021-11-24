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

    public int[] productExceptSelf2021(int[] nums) {

        int l[] = new int[nums.length];
        int r[] = new int[nums.length];

        l[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                l[i] = nums[i];
                continue;
            }
            l[i] = nums[i] * l[i-1];
        }

        int multi = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i==0) {
                r[i] = multi;
                break;
            }
            r[i] = l[i-1]*multi;
            multi *= nums[i];
        }

        return r;
    }
}