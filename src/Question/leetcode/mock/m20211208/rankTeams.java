package Question.leetcode.mock.m20211208;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class rankTeams {

    public static void main(String[] args) {
        rankTeams q = new rankTeams();
        String[] s = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        q.rankTeams(s);
    }

    public String rankTeams(String[] votes) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,int[]> m = new HashMap<>();
        int n = votes[0].length();

        for (int i = 0; i < votes[0].length(); i++) {
            m.put(votes[0].charAt(i),new int[n+1]);
        }

        PriorityQueue<Map.Entry<Character,int[]>> q = new PriorityQueue<>((e1, e2) -> {
            int[] e1o = e1.getValue();
            int[] e2o = e2.getValue();

            int i = 1;

            while (i <= n && e1o[i] == e2o[i]) {
                i++;
            }

            if (i == (n + 1)) {
                return e1.getKey() - e2.getKey();
            } else {
                return e2o[i] - e1o[i];
            }
        });


        for (String s:votes) {
            char[] cs = s.toCharArray();

            for (int i = 0; i < cs.length; i++) {
                m.get(cs[i])[i+1] ++;
            }
        }
        q.addAll(m.entrySet());

        while (!q.isEmpty()){
            sb.append(q.poll().getKey());
        }

        return sb.toString();
    }
}
