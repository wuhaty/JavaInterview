package Question.leetcode.weeklyContest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gump on 2019/12/26.
 */
public class W166Q1283 {

    public static void main (String args[]){
        W166Q1283 q = new W166Q1283();
        int t[] = {1,2,5,9};
        q.smallestDivisor(t,6);
    }



    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i],max);
        }

        int lo = 1;
        int hi = max;

        while (lo < hi){
            int mid = (lo + hi)/2;
            int sum = getSum(nums,mid);
            if (sum<=threshold) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }

    private int getSum(int[] nums, int divisor) {
        int res =0 ;
        for (int i:nums) {
            res += Math.ceil((i+(0.0))/divisor);
        }
        return res;
    }
}
