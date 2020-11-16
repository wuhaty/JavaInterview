package Question.leetcode.weeklyContest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/11/24.
 */
public class W59Q728 {

    public static void main(String argc[]){
        W59Q728 q =new W59Q728();
        System.out.println(q.selfDividingNumbers(1,22));
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            while (j>0){
                int temp = j%10;
                if (temp!=0 && i%temp==0){
                    j/=10;
                    continue;
                }else{
                    break;
                }
            }

            if (j==0) result.add(i);
        }
        return result;
    }
}
