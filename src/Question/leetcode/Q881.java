package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2018/8/18.
 */
public class Q881 {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        int dp[][] = new int[n][limit+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= limit; j++) {
                if (people[i] >j) continue;
                else {
                    dp[i][j] = Math.min(dp[i-1][j-limit],dp[]);
                }
            }
        }
    }
}
