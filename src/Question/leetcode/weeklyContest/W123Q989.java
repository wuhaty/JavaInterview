package Question.leetcode.weeklyContest;

import java.util.LinkedList;
import java.util.List;

public class W123Q989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int i=A.length-1,adder = 0;
        List<Integer> res = new LinkedList<>();

        while (adder>0 || K > 0 || i >=0){
            int r = K%10;
            K/=10;

            int score = (i>=0?A[i]:0) + r + adder;

            res.add(0,(score) %10);
            if (score>=10) {
                adder =1;
            }else {
                adder =0;
            }
            i--;
        }
        return res;
    }

}
