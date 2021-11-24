package Question.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first>0 && nums[first] == nums[first-1]) {
                continue;
            }

            int target = -nums[first];

            for (int second = first+1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int third = n-1;
                while (third > second && (nums[second] + nums[third]) > target) {
                    third--;
                }

                if (second == third) {
                    //second exhausted,abort
                    break;
                }

                if ((nums[second] + nums[third]) == target) {
                    List<Integer> l = new LinkedList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    res.add(l);
                }
            }
        }

        return res;
    }
}
