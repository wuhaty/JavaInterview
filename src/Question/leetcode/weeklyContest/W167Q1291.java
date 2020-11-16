package Question.leetcode.weeklyContest;

import java.util.LinkedList;
import java.util.List;

public class W167Q1291 {


    public static void main(String args[]){
        W167Q1291 q = new W167Q1291();

        q.sequentialDigits(1000,13000);
    }


    public List<Integer> sequentialDigits(int low, int high) {

        String l = String.valueOf(low);
        String h = String.valueOf(high);
        List<Integer> res = new LinkedList<>();
        int i = l.length();

        while (i<=h.length()){

            //init
            int t[] = new int[i];
            t[0] = 1;
            for (int j = 1; j < t.length; j++) {
                t[j] = t[j-1] + 1;
            }

            while (t[t.length - 1] <= 9){
                int sum = calculate(t);
                if (sum > high) break;
                if (sum<=high && sum >=low) res.add(sum);


                for (int j = 0; j < t.length; j++) {
                    t[j] ++;
                }
            }
            i++;
        }

        return res;
    }

    private int calculate(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum = (sum * 10 + t[i]);
        }
        return sum;
    }
}
