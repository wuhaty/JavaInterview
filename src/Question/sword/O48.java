package Question.sword;

import java.util.HashMap;
import java.util.Map;

public class O48 {

    public static void main(String[] args) {
        O48 q = new O48();
        q.lengthOfLongestSubstring("abba");
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> lastOccurance = new HashMap<>();
        char[] cs = s.toCharArray();

        int max = 0;
        int pre = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            int t = 0;
            if (lastOccurance.containsKey(c)) {
                int last = lastOccurance.get(c);
                int l = i - pre;
                if (last<l) {
                    t = pre + 1;
                }else {
                    t = i - last;
                }
            }else {
                t = pre + 1;
            }
            lastOccurance.put(c,i);
            pre = t;
            max = Math.max(max,t);
        }

        return max;
    }
}
