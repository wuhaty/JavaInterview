package Question.mspractice;

import java.util.*;

public class M49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();
        for (String s:strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String ns = String.valueOf(cs);
            m.putIfAbsent(ns,new LinkedList<>());
            m.get(ns).add(s);
        }

        return new LinkedList<>(m.values());
    }
}
