package Question.leetcode;

/**
 * Created by gump on 2021/10/19.
 */
public class Q154 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l<r) {
            int i = (l+r)/2;
            int pivot = nums[i];

            if (nums[r]>pivot) {
                r=i;
            }else if (nums[r]<pivot) {
                l = i+1;
            }else {
                r--;
            }
        }

        return nums[l];
    }
}
