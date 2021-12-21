package Question.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        List<Integer> res = new LinkedList<>();

        int l=0,r=nums.length-1;
        while (l<=r){
            int lp = nums[l] * nums[l];
            int rp = nums[r] * nums[r];

            if (lp>rp){
                res.add(0,lp);
                l++;
            }else {
                res.add(0,rp);
                r--;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
