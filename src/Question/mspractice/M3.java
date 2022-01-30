package Question.mspractice;

import java.util.HashMap;
import java.util.Map;

public class M3 {
    public static void main(String[] args) {
        M3 m = new M3();
        m.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> m = new HashMap<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        int max = 0;
        int l = 0;

        for (int i = 0; i < n; i++) {
            if (m.containsKey(cs[i])){
                //to deal with case like 'abba',
                //violation case could already happen after last occurrence
                l = Math.max(l,m.get(cs[i])+1);
            }
            m.put(cs[i],i);
            max = Math.max(max, i - l +1);
        }

        return max;
    }
}
