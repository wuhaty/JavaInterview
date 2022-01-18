package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q3_2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        char[] cs = s.toCharArray();
        Map<Character,Integer> m = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < cs.length; i++) {
            if (m.containsKey(cs[i])) {
                //max of 1.last occurrence  2.last index without duplicates
                //e.g abba
                left = Math.max(left,m.get(cs[i])+1);
            }

            m.put(cs[i],i);
            ans = Math.max(ans,i-left+1);
        }

        return ans;
    }
}
