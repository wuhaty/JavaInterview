package Question.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gump on 2017/5/24.
 */
public class Q446 {
    public static void main(String argc[]){
        Q446 q= new Q446();
        int a[] = {1, 2,3};
        q.numberOfArithmeticSlices(a);
    }


    public int numberOfArithmeticSlices(int[] A) {
        if (A ==null || A.length<3) return 0;
        int n = A.length;
        HashMap<Integer,Integer> map[] = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = A[i] - A[j];

                if(diff<Integer.MIN_VALUE || diff >Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int c1 = map[i].getOrDefault(d,0);
                int c2 = map[j].getOrDefault(d,0);
                res+=c2;
                map[i].put(d,c1+c2+1);
            }
        }
        return res;
    }
}
