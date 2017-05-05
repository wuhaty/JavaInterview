package Question.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2017/5/5.
 */
public class Q279 {

    Map<Integer,Integer> map = new HashMap();

    public static void main(String argc[]){
        Q279 q = new Q279();
        System.out.println(q.numSquares(12));
    }

    private int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int j = 1;
            while (i-j*j>=0){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                ++j;
            }
        }
        return dp[n];
    }

    public int numSquaresOri(int n) {
        if(n<=3){
            map.put(n,1);
            return n;
        }

        int result=Integer.MAX_VALUE;
        for (int i = 2; i*i <= n; i++) {
            if(map.containsKey(n-i*i)){
                result = Math.min(result,1+map.get(n-i*i));
            }else{
                int temp = numSquaresOri(n-i*i);
                result = Math.min(result,1+temp);
                map.put(n-i*i,temp);
            }
        }
        return result;
    }



}
