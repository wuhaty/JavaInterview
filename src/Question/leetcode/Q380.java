package Question.leetcode;

import java.util.*;

public class Q380 {

    HashMap<Integer,Integer> m;
    List<Integer> l;
    Random random = new Random();

    public Q380() {
        m = new HashMap<>();
        l = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (m.containsKey(val)) return false;
        m.put(val,l.size());
        l.add(l.size(),val);
        return true;
    }

    public boolean remove(int val) {
        if (!m.containsKey(val)) return false;

        int index = m.get(val);
        m.put(l.get(l.size()-1),index);
        l.set(index,l.get(l.size()-1));


        m.remove(val);
        l.remove(l.size()-1);
        return true;
    }

    public int getRandom() {
        return l.get(random.nextInt(l.size()));
    }

}
