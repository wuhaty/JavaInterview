package Question.leetcode.weeklyContest;

import java.util.*;

/**
 * Created by gump on 2020/1/12.
 */
public class W169Q1306 {

    public boolean canReach(int[] arr, int start) {
        Map<Integer,List<Integer>> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int l = i - arr[i];
            int r = i + arr[i];

            if (l >= 0 ) {
                m.putIfAbsent(i, new LinkedList<>());
                m.get(i).add(l);
            }

            if (r<arr.length) {
                m.putIfAbsent(i, new LinkedList<>());
                m.get(i).add(r);
            }
        }

        HashSet s = new HashSet();
        return helper(m,start,arr,s);
    }

    private boolean helper(Map<Integer, List<Integer>> m, int start,int[] arr,HashSet<Integer> s) {
        if (!m.containsKey(start)) return false;
        if (arr[start] == 0) return true;

        boolean f = false;
        List<Integer> child = m.get(start);

        //judge circle
        if (s.contains(start)) return false;
        else s.add(start);

        for (Integer i : child) {
            f = (f || helper(m,i,arr,s));
            if (f) return true;
        }
        s.remove(s);
        return f;
    }
}
