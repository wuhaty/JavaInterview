package Question.mspractice;

import java.util.HashMap;
import java.util.Map;

public class M560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, preSum = 0;

        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (m.containsKey(preSum - k)){
                count+=m.get(preSum - k);
            }
            m.put(preSum,m.getOrDefault(preSum,0)+1);
        }

        return count;
    }
}
