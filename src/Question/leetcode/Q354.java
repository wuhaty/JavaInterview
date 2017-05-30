package Question.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gump on 2017/5/28.
 */
public class Q354 {

    public static void main(String argc[]){
        int data[][] = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        Q354 q = new Q354();
        q.maxEnvelopes(data);
    }


    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length==0) return 0;

        int n = envelopes.length;
        int dp[] = new int[n];
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int len = 0;
        for (int envelope[] :envelopes) {
            int i = Arrays.binarySearch(dp,0,len,envelope[1]);
            if (i<0) i = -(i+1);

            dp[i] = envelope[1];
            if (i==len) len++;
        }
        return len;
    }
}
