package Question.mspractice.mock.d8;

import java.util.*;

public class q2 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> usage = new TreeMap<>();

        for (int i = 0; i < keyName.length; i++) {
            usage.putIfAbsent(keyName[i],new LinkedList<>());
            String[] time = keyTime[i].split(":");
            Integer mins = Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
            usage.get(keyName[i]).add(mins);
        }

        List<String> res = new LinkedList<>();

        for (Map.Entry<String,List<Integer>> e:usage.entrySet()) {
            String user = e.getKey();
            List<Integer> l = e.getValue();
            l.sort((Comparator.comparingInt(o -> o)));

            for (int i = 0; i <= l.size()-3; i++) {
                int j = i + 2;
                if (l.get(j) - l.get(i) <= 60){
                    res.add(user);
                    break;
                }
            }
        }

        return res;
    }
}
