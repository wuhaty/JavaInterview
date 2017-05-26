package Question.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/5/24.
 */
public class Q539 {

    public static void main(String argc[]){
        Q539 q = new Q539();
        List<String> time = new ArrayList<>();
        time.add("23:59");
        time.add("00:00");
        q.findMinDifference(time);
    }


    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(String::compareTo);

        int min = Integer.MAX_VALUE;
        int n = timePoints.size();

        for (int i = 0; i < timePoints.size(); i++) {
            String temp = timePoints.get(i);
            String pre = i==0 ? timePoints.get(n-1):timePoints.get(i-1);
            String next = i==n-1 ? timePoints.get(0):timePoints.get(i+1);

            int diff = Math.min(getDiff(temp,pre),getDiff(temp,next));
            min = Math.min(min,diff);
        }
        return min;
    }

    private int getDiff(String a, String b) {
        String tempA[] = a.split(":");
        String tempB[] = b.split(":");
        int ta = Integer.parseInt(tempA[0])*60 + Integer.parseInt(tempA[1]);
        int tb = Integer.parseInt(tempB[0])*60 + Integer.parseInt(tempB[1]);

        return Math.min(Math.abs(ta-tb),1440-Math.abs(ta-tb));
    }
}
