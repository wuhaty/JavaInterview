package Question.mspractice;

import java.util.*;
import java.util.stream.Collectors;

public class M269 {
    public static void main(String[] args) {
        M269 q = new M269();
        q.alienOrder(new String[]{"wrt","wrtkj"});
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> m = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree,-1);

        for (int k = 1; k < words.length; k++) {
            String cur = words[k];
            String pre = words[k-1];

            if (cur.equals(pre)) continue;

            int i = 0, j = 0;
            while (i<cur.length() && j <pre.length() && cur.charAt(i) == pre.charAt(j)){
                i++;
                j++;
            }

            if (j< pre.length() && i == cur.length()) return "";
            if (j == pre.length()) continue;


            char source = pre.charAt(j);
            char dest = cur.charAt(i);


            m.putIfAbsent(source,new LinkedList<>());
            m.get(source).add(dest);
        }

        for (String s:words) {
            for (char c:s.toCharArray()) {
                inDegree[c-'a'] = 0;
            }
        }

        int count = 0;
        for (char source:m.keySet()) {
            for (char dest:m.get(source)) {
                inDegree[dest - 'a'] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != -1) count++;
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()){
            int index = q.poll();
            char source = (char) ('a' + index);
            sb.append(source);

            if (m.containsKey(source)){
                for (char dest:m.get(source)) {
                    inDegree[dest-'a']--;
                    if (inDegree[dest-'a'] ==0){
                        q.offer(dest-'a');
                    }
                }
            }
        }

        if (sb.length() != count) return "";
        else return sb.toString();
    }
}
