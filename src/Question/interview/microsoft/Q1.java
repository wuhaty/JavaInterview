package Question.interview.microsoft;

import java.util.ArrayList;

/**
 * Created by gump on 2017/9/29.
 */
public class Q1 {

    public static void main(String argc[]){
        Q1 q = new Q1();
        System.out.println(q.numbersByRecursion(2));
    }


    public ArrayList<Integer> numbersByRecursion(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        perm(n,0,result);
        return result;
    }

    public void perm(int index,int n,ArrayList<Integer> result) {
        if(index == 0){
            if (n!=0)
                result.add(n);
            return;
        }

        for (int i = 0; i < 10; i++) {
            perm(index-1,10*n+i,result);
        }
    }
}
