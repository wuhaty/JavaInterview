package Question.mspractice;

import java.util.*;

public class M380 {
    Map<Integer,Integer> m;
    List<Integer> l;
    Random r;
    public M380() {
        m = new HashMap<>();
        l = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (m.containsKey(val)) return false;
        m.put(val,l.size());
        l.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!m.containsKey(val)) return false;

        int oldIndex = m.get(val);
        l.set(oldIndex,l.get(l.size()-1));
        m.put(l.get(l.size()-1),oldIndex);
        m.remove(val);
        l.remove(l.size()-1);
        return true;
    }

    public int getRandom() {
        return l.get(r.nextInt(l.size()));
    }
}
