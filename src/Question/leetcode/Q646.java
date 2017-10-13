package Question.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gump on 2017/9/19.
 */
public class Q646 {
    public static void main(String argc[]){
        Q646 q = new Q646();
        int input[][] = new int[7][2];
        input[0] = new int[]{-1,1};
        input[1] = new int[]{-2,7};
        input[2] = new int[]{-5,8};
        input[3] = new int[]{-3,8};
        input[4] = new int[]{1,3};
        input[5] = new int[]{-2,9};
        input[6] = new int[]{-5,2};

        q.findLongestChain(input);
    }


    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(pairs, (o1, o2) -> o1[0]-o2[0]);

        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    res = Math.max(dp[i],res);
                }
            }
        }
        return res;
    }
}
