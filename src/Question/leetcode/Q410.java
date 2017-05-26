package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/22.
 */
public class Q410 {

    public static void main (String argc[]){
        int nums[] = {7,2,5,10,8};
        Q410 q = new Q410();
        q.splitArray(nums,2);
    }



    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i:nums) {
            max = Math.max(max,i);
            sum += i;
        }

        if(m == nums.length) return max;
        if(m == 1) return sum;

        long l = max;
        long r = sum;

        while (l<=r){
            long mid = (l+r) /2;

            if (valid(mid,nums,m)){
                r = mid -1;
            }else{
                l = mid +1;
            }
        }

        return (int)l;
    }

    private boolean valid(long mid, int[] nums, int m) {
        int count =1 ;

        long sum = 0;
        for (int i:nums) {
            sum+=i;

            if(sum>mid){
                sum = i;
                count++;
                if (count>m) return false;
            }
        }
        return true;
    }
}
