package Question.leetcode.weeklyContest;

import java.util.*;

public class W156Q1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> m = new HashMap<>();

        for (int i : arr) {
            if (!m.containsKey(i)){
                m.put(i,1);
            }else{
                m.put(i,m.get(i)+1);
            }
        }

        Set s = new HashSet();

        for (Integer e:m.values()) {
            if (!s.contains(e)){
                s.add(e);
                continue;
            }
            else return false;
        }
        return true;
    }
}
