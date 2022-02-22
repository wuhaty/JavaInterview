package Question.leetcode.book.interviewSummary;

import java.util.HashSet;
import java.util.Set;

public class I128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i :nums) {
            s.add(i);
        }

        int ans = 0;
        for (int i:s) {
            if (!s.contains(i-1)){
                int len = 1;
                while (s.contains(i+len)){
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }

        return ans;
    }
}
