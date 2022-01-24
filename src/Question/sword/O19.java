package Question.sword;

public class O19 {
    public boolean isMatch(String s, String p) {
        if (p == null || s == null) return false;

        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                char sc = i==0?'x':s.charAt(i-1);
                char pc = p.charAt(j-1);

                if (pc == '*'){
                    char pre = p.charAt(j-2);
                    if (match(sc,pre)){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }else {
                    if (match(sc,pc)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }

        return dp[n][m];
    }

    private boolean match(char s,char p){
        if (p == '.') return true;

        return s==p;
    }
}
