package Question.leetcode.weeklyContest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2019/12/25.
 */
public class W168Q1297 {

    public static void main(String args[]){
        W168Q1297 q = new W168Q1297();
        q.maxFreq("edbbdaaaacbbdbdacaccecacaeceaaedccdededbdbabebebce",
                1,
                4,
                13);
    }


    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int pre =0;
        int res = 0;
        Map<Character,Integer> count = new HashMap<>();
        Map<String,Integer> occurence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.putIfAbsent(c,0);
            count.put(c,count.get(c)+1);

            if (i-pre+1>minSize){
                count.put(s.charAt(pre),count.get(s.charAt(pre))-1);
                if (count.get(s.charAt(pre)) ==0){
                    count.remove(s.charAt(pre));
                }
                pre++;
            }

            if (i-pre+1 ==minSize && count.keySet().size() <=maxLetters){
                String str= s.substring(pre,i+1);
                occurence.putIfAbsent(str,0);
                occurence.put(str,occurence.get(str)+1);
                res = Math.max(res,occurence.get(str));
            }
        }
        return res;
    }
}
