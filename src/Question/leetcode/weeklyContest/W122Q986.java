package Question.leetcode.weeklyContest;

import Question.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.List;


public class W122Q986 {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int i=0,j=0;

        List<Interval> retList = new ArrayList<Interval>();

        while (i<A.length && j < B.length){
            if (A[i].end < B[j].start){
                i++;
            }else if(A[i].start > B[j].end){
                j++;
            }else {
                retList.add(new Interval(Math.max(A[i].start,B[j].start),Math.min(A[i].end,B[j].end)));
                if (A[i].end<B[j].end) i++;
                else j++;
            }
        }

        return retList.toArray(new Interval[retList.size()]);
    }
}
