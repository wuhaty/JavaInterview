package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2017/5/10.
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public int[] twoSum2021(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int j = target-nums[i];
            if (m.containsKey(j) && i != m.get(j)) {
                res[0] = i;
                res[1] = m.get(j);
                return res;
            }
            m.put(nums[i],i);
        }

        return res;
    }
}
