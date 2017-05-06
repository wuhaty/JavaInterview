package Question.leetcode;

/**
 * Created by gump on 2017/5/6.
 */
public class Q516 {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];

        for (int i = dp.length-1; i >=0 ; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < dp[0].length; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = 2+dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()-1][s.length()-1];
    }
}
