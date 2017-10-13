package Question.leetcode;

import java.util.HashMap;

/**
 * Created by gump on 2017/9/23.
 */
public class Q397 {

    public static void main(String argc[]){
        Q397 q = new Q397();
        System.out.println(q.integerReplacement(1000));
    }


    public int integerReplacement(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(2,1);
        map.put(1,0);

        return helper(n,n,map);
    }

    private int helper(int n, int ori,HashMap<Integer, Integer> map) {
        if (n == Integer.MAX_VALUE) return 32; //n = 2^31-1;

        if (map.containsKey(n)){
            return map.get(n);
        }else{
            if (n%2 ==1){
                int upper = n+1<=ori+1? 1+helper(n+1,n,map): Integer.MAX_VALUE;
                int lower = 1+helper(n-1,n,map);
                return Math.min(upper,lower);
            }else{
                int halfer = 1+helper(n/2,n,map);
                return halfer;
            }
        }
    }
}
