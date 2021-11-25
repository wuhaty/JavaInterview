package Question.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q1239 {
    int max = 0;

    public static void main(String[] args) {
        List<String> l = List.of("un","iq","ue");
        Q1239 q = new Q1239();
        q.maxLength(l);
    }

    public int maxLength(List<String> arr) {
        List<Integer> masks = new LinkedList<>();
        for (String s:arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (((mask >> c)&1) != 0) {
                    //contains duplicated char, skip
                    mask = 0;
                    break;
                }
                mask |= (1<<c);
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks,0,0);
        return max;
    }

    private void backtrack(List<Integer> masks, int mask,int s){
        if (s >= masks.size()) {
            max = Math.max(max,Integer.bitCount(mask));
            return;
        }

        if ((masks.get(s) & mask) == 0){
            //no duplicated char
            backtrack(masks,mask|masks.get(s),s+1);
        }else {
            backtrack(masks,mask,s+1);
        }
    }


    public int maxLengthOri(List<String> arr) {
        backtrackOri(arr,new StringBuilder(),0);
        return max;
    }

    private void backtrackOri(List<String> arr, StringBuilder sb, int s) {
        if (s >= arr.size()) {
            max = Math.max(max,sb.length());
            return;
        }

        String str = arr.get(s);
        sb.append(str);
        HashSet<Character> set = new HashSet<>();
        for (int j = 0; j < sb.length(); j++) {
            set.add(sb.charAt(j));
        }

        if (sb.length() == set.size()){
            backtrackOri(arr,sb,s+1);
        }
        sb.delete(sb.length()-str.length(),sb.length());
        backtrackOri(arr,sb,s+1);
    }
}
