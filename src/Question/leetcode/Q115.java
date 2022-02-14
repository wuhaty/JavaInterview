package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/17.
 */
public class Q115 {

    public static void main (String argc[]){
        Q115 q =new Q115();
//        q.numDistinct("rabbbit","rabbit");
        q.numDistinct2022("r","r");
    }

    public int numDistinct(String s, String t) {
        int dp[] = new int[s.length()+1];
        int temp[] = new int[s.length()+1];
        Arrays.fill(dp,1);

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (s.charAt(j-1) == t.charAt(i-1)){
                    temp[j] = dp[j-1] + temp[j-1];
                }else {
                    temp[j] = temp[j-1];
                }
            }
            for (int k = 0; k < temp.length; k++) {
                dp[k] = temp[k];
                temp[k] = 0;
            }
        }
        return dp[s.length()];
    }

    public int numDistinct2022(String s, String t){
        int n = s.length();
        int m = t.length();


        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }

        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >=0; j--) {
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
