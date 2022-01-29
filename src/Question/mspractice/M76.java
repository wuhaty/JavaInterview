package Question.mspractice;

import java.util.*;

public class M76 {
    public String minWindow(String s, String t) {
        if (t.length()>s.length()) return "";

        Map<Character,Integer> ori = new HashMap<>();
        Map<Character,Integer> cnt = new HashMap<>();

        for (char c:t.toCharArray()) {
            ori.put(c,ori.getOrDefault(c,0)+1);
        }

        int l=0,r=-1,ansL=-1,ansR=-1,len = Integer.MAX_VALUE;

        while (r<s.length()){
            r++;

            if (r<s.length() && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }

            while (l<=r && check(ori,cnt)){
                if (r-l+1<len){
                    ansL = l;
                    ansR = r+1;
                    len = r-l+1;
                }

                if (ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.get(s.charAt(l))-1);
                }
                l++;
            }
        }

        return ansL == -1?"": s.substring(ansL,ansR);
    }

    private boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> e:ori.entrySet()) {
            if (cnt.getOrDefault(e.getKey(),0) < e.getValue()){
                return false;
            }
        }
        return true;
    }

}
