package Question.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public static void main(String argc[]){
        Q56 q = new Q56();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,4));
        list.add(new Interval(1,4));
        System.out.println(q.merge(list));
    }
}
