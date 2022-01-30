package Question.mspractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class M253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        q.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (q.peek()[1] <= intervals[i][0]){
                q.poll();
            }
            q.offer(intervals[i]);
        }

        return q.size();
    }
}
