package Question.leetcode;

public class Q44 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*'){
                    dp[i][j] = dp[i][j-1] || (i > 0 && dp[i - 1][j]);
                }else if (i > 0 && match(s.charAt(i-1),pc)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[n][m];
    }

    private boolean match(char c, char p){
        if (p == '?') return true;

        return c == p;
    }
}
