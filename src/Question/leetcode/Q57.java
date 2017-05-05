package Question.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/5/4.
 */
public class Q57 {
    public static void main(String argc[]){
        Q57 q = new Q57();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));
        System.out.print(q.insert(intervals,new Interval(0,3)));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        int j = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(interval.start>newInterval.start){
                intervals.add(i,newInterval);
                j=i;
                if(j==0) j++;
                break;
            }else if(i==intervals.size()-1){
                intervals.add(newInterval);
                j=i+1;
                break;
            }
        }

        for (; j < intervals.size(); j++) {
            Interval curr = intervals.get(j);
            Interval pre = intervals.get(j-1);
            if(pre.end>=curr.start){
                if(curr.end>pre.end) pre.end = curr.end;
                intervals.remove(j);
                j--;
            }
        }
        return intervals;
    }
}
