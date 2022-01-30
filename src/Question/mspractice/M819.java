package Question.mspractice;

import java.util.HashMap;
import java.util.Map;

public class M819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?',;.]"," ").toLowerCase();

        Map<String, Integer> m = new HashMap<>();
        for (String s:paragraph.split(" ")) {
            if (s.isEmpty()) continue;
            m.put(s,m.getOrDefault(s,0)+1);
        }

        for (String s:banned) {
            m.remove(s);
        }

        String ans = null;
        Integer max = 0;
        for (Map.Entry<String, Integer> e:m.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                ans = e.getKey();
            }
        }

        return ans;
    }
}
