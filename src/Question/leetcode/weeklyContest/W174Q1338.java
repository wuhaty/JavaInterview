package Question.leetcode.weeklyContest;

import java.util.*;

public class W174Q1338 {
    public int minSetSize(int[] arr) {
        int res = 0;
        Map<Integer,Integer> m = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i],m.getOrDefault(arr[i],0)+1);
        }

        int max = 0;
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        m.values().forEach(q::offer);

        while (max <(arr.length/2)){
            max += q.poll();
            res++;
        }
        return res;
    }
}
