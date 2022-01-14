package Question.sword;

import java.util.HashSet;
import java.util.Set;

public class O57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(target-nums[i])) {
                int[] res = new int[2];
                res[0] = nums[i];
                res[1] = target - nums[i];
                return res;
            }else{
                s.add(nums[i]);
            }
        }
        return null;
    }

    public int[] twoSum2Pointers(int[] nums, int target) {
        int p = 0, q = nums.length-1;
        while (p<q){
            int s = nums[p] + nums[q];
            if (s == target) {
                int[] res = new int[]{nums[p],nums[q]};
                return res;
            }else if (s > target) {
                p ++;
            }else {
                q --;
            }
        }
        return null;
    }
}
