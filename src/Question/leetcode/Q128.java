package Question.leetcode;

import java.util.HashMap;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])){
                int left = m.getOrDefault(nums[i]-1,0);
                int right = m.getOrDefault(nums[i]+1,0);

                int cur = 1+left+right;
                max = Math.max(cur,max);

                m.put(nums[i],cur);
                m.put(nums[i]-left,cur);
                m.put(nums[i]+right,cur);
            }
        }
        return max;
    }
}
