package Question.leetcode;

import java.util.Objects;

/**
 * Created by gump on 2017/10/14.
 */
public class Q583 {


    public static void  main(String argc[]){
        Q583 q = new Q583();
        System.out.println(q.minDistance("mart","karma"));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n+m-2*dp[n][m];
    }
}
