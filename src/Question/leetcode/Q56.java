package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/4/21.
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Q56 {


    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;

        intervals.sort(Comparator.comparingInt(i -> i.start));


        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval i:intervals) {
            if(i.start<= end){
                end = i.end;
            }else{
                result.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> l = new LinkedList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1],end);
            }else{
                l.add(List.of(start,end));
                start = intervals[i][0];
                end = intervals[i][1];

            }
        }
        l.add(List.of(start,end));

        int[][] res = new int[l.size()][2];

        for (int i = 0; i < l.size(); i++) {
            res[i][0] = l.get(i).get(0);
            res[i][1] = l.get(i).get(1);
        }

        return res;
    }

    public static void main(String argc[]){
        Q56 q = new Q56();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,4));
        list.add(new Interval(1,4));
        System.out.println(q.merge(list));
    }
}
