package Question.mspractice;

import java.util.*;

public class M692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        Map<String,Integer> m = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer> > q = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue() == 0? o1.getKey().compareTo(o2.getKey()):o2.getValue()-o1.getValue();
            }
        });

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            m.put(s,m.getOrDefault(s,0)+1);
        }

        for (Map.Entry e:m.entrySet()) {
            q.offer(e);
        }

        while (k-->0){
            res.add(q.poll().getKey());
        }

        return res;
    }
}
