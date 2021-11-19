package Question.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gump on 2021/6/27.
 */
public class Q253 {

    public static void main(String[] args) {
        Q253 q = new Q253();
        int[][] intervals = {
                {7,10},{2,4}
        };
        q.minMeetingRooms(intervals);
    }

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> allocator = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        allocator.add(intervals[0][1]);


        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=allocator.peek()){
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public int minMeetingRooms2021(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o->o));

        q.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>q.peek()) {
                q.poll();
            }
            q.add(intervals[i][1]);
        }

        return q.size();
    }
}
