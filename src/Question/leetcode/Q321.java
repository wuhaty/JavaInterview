package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2017/5/17.
 */
public class Q321 {

    public static void main(String argc[]){
        Q321 q = new Q321();
        int nums1[] = {6,7};
        int nums2[] = {6,0,4};
        q.maxNumber(nums1,nums2,5);
    }


    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int ans[] = new int[k];

        for (int i = Math.max(0,k-m); i <= n && i<=k ; i++) {
            int candidate[] = merge(getMax(nums1,i),getMax(nums2,k-i),k);
            if(greater(candidate,0,ans,0)) ans = candidate;
        }
        return ans;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
            i++;j++;
        }
        return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
    }

    private int[] merge(int[] nums1, int[] nums2,int k) {
        int ans[] = new int[k];
        for (int i = 0,j=0,r=0; r<k;r++) {
            if (greater(nums1,i,nums2,j)) ans[r] = nums1[i++];
            else ans[r] = nums2[j++];
        }
        return ans;
    }

    private int[] getMax(int[] nums, int k) {
        int ans[] = new int[k];
        int n = nums.length;
        for (int i = 0,j=0; i < nums.length; i++) {
            while (j+n-i>k && j>0 && ans[j-1]<nums[i]) j--;

            if(j<k) ans[j++] = nums[i];
        }

        return ans;
    }

}
