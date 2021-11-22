package Question.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gump on 2017/5/6.
 */
public class Q3 {

    public  static void main (String argc[]){
        Q3 q = new Q3();
        System.out.println(q.lengthOfLongestSubstring2021("pwwkew"));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2021Ori(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] cs = s.toCharArray();
        int res = 0;
        int pre = 0;
        int i = 0;
        while (i < cs.length){
            if (set.contains(cs[i])) {
                //cs[i] cannot be added , find the next start pos
                for (; pre < i; pre++) {
                    if (cs[pre] == cs[i]) break;
                }
                set.clear();
                i = pre +1;
                pre ++;
            }else {
                set.add(cs[i]);
                res = Math.max(res,set.size());
                i ++;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring2021(String s) {
        Map<Character,Integer> m = new HashMap<>();
        int res = 0;
        char[] cs = s.toCharArray();

        for (int i = 0,pre=0; i < cs.length; i++) {
            if (m.containsKey(cs[i])) {
                //violation at index i, find next start point
                pre = Math.max(pre,m.get(cs[i])+1);
            }
            m.put(cs[i],i);
            res = Math.max(res, i - pre + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstringOri(String s) {
        char input[] = s.toCharArray();
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < input.length; j++) {
                if(!set.contains(input[j])){
                    set.add(input[j]);
                }else {
                    break;
                }
            }
            max = Math.max(set.size(),max);
        }
        return max;
    }
}
