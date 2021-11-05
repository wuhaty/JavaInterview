package Question.leetcode.weeklyContest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by gump on 2019/12/26.
 */
public class W166Q1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<List<Integer>>> m = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            m.putIfAbsent(groupSizes[i],new LinkedList<>());

            boolean f = false;
            for (List<Integer> l : m.get(groupSizes[i])) {
                if (l.size() != groupSizes[i]) {
                    f = true;
                    l.add(i);
                }
            }
            if (!f){
                LinkedList<Integer> init = new LinkedList<>();
                init.add(i);
                m.get(groupSizes[i]).add(init);
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        for (List<List<Integer>> k:m.values()) {
            res.addAll(k);
        }

        return res;
    }
}
