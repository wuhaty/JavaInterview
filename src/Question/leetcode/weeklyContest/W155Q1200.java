package Question.leetcode.weeklyContest;

import java.util.*;

/**
 * Created by gump on 2019/9/28.
 */
public class W155Q1200 {

    public static void main(String args[]){
        W155Q1200 q = new W155Q1200();
        int[] arr = {1,3,6,10,15};
        q.minimumAbsDifference(arr);
    }



    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<Integer> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        for (int i:arr) {
            temp.add(i);
        }
        Collections.sort(temp);

        Map<Integer,List<List<Integer>>> m = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size()-1; i++) {
            int diff =temp.get(i+1) - temp.get(i);
            if (diff<min) min = diff;
            m.putIfAbsent(diff,new LinkedList<>());
            List<Integer> te = new LinkedList<>();
            te.add(temp.get(i));
            te.add(temp.get(i+1));
            m.get(diff).add(te);
        }
        return m.get(min);
    }

}
