package Question.leetcode;

public class Q91_2 {

    public int numDecodings(String s) {
        if (s != null  && s.startsWith("0")) return 0;

        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }

            if (i>1 && i+1 <=n && s.charAt(i-2) != '0' && check(s.substring(i-1,i+1))){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    private boolean check(String substring) {
        int i = Integer.parseInt(substring);
        return i>=1 && i<=26;
    }
}
