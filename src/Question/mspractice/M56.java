package Question.mspractice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class M56 {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] l:intervals) {
            q.offer(l);
        }

        List<int[]> wrapper = new LinkedList<>();
        int end = -1;

        while (!q.isEmpty()){
            int[] interval = q.poll();

            if (interval[0]> end){
                wrapper.add(interval);
                end = interval[1];
            }else {
                end = Math.max(interval[1],wrapper.get(wrapper.size()-1)[1]);
                wrapper.get(wrapper.size()-1)[1] = end;
            }
        }

        return wrapper.toArray(new int[wrapper.size()][]);
    }
}
