package Question.classified.DP;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i:nums) {
            s.add(i);
        }

        int ans = 0;
        for (Integer i:s) {
            if (!s.contains(i-1)){
                int score = 1;

                while (s.contains(i+1)){
                    i = i+1;
                    score ++;
                }
                ans = Math.max(ans,score);
            }
        }

        return ans;
    }
}
