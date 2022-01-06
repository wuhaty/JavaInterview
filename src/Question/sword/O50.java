package Question.sword;

import java.util.*;

public class O50 {

    public static void main(String[] args) {
        O50 q = new O50();
        q.firstUniqChar("aadadaad");
    }

    public char firstUniqChar(String s) {
        Set<Character> occurance = new HashSet<>();
        Map<Character,Integer> m = new HashMap<>();
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (!occurance.contains(cs[i]) && !m.containsKey(cs[i])) {
                occurance.add(cs[i]);
                m.put(cs[i],i);
            }else {
                m.remove(cs[i]);
            }
        }

        if (m.isEmpty()) return ' ';
        int index = Integer.MAX_VALUE;
        char res = ' ';
        for (Map.Entry<Character,Integer> e :m.entrySet()) {
            if (e.getValue() < index) {
                res = e.getKey();
                index = e.getValue();
            }
        }

        return res;
    }

    public char firstUniqCharCountArray(String s) {
        int count[] = new int[26];
        char[] cs = s.toCharArray();

        for (char c:cs) {
            count[c-'a'] ++;
        }

        for (char c:cs) {
            if (count[c-'a'] == 1) return c;
        }

        return ' ';
    }
}
