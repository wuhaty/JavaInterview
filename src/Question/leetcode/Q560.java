package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q560 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int pre = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            pre = 0;
            for (int j = i; j < n; j++) {
                pre = ((j-1)<0?0:pre) + nums[j];
                if (pre == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySumOpt(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int n = nums.length;
        int res = 0;
        int preSum = 0;
        m.put(0,1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (m.containsKey(preSum-k)){
                res+= m.get(preSum-k);
            }
            m.put(preSum,m.getOrDefault(preSum,0)+1);
        }
        return res;
    }
}
