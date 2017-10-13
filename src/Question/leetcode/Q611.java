package Question.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by gump on 2017/8/14.
 */
public class Q611 {

    public static void main(String argc[]){
        Q611 q =new Q611();
        int nums[] = {2,2,3,4};
        System.out.println(q.triangleNumber(nums));
    }

    public int binarySerach(int num[],int lo,int hi,int key){
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if (num[mid] < key){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return lo;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            int k = i+2;
            for (int j = i+1; j < n-1; j++) {
                k = binarySerach(nums,k,n-1,nums[i]+nums[j]);
                count += k-j-1;
            }
        }
        return count;
    }
}
