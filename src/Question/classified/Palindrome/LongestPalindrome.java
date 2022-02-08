package Question.classified.Palindrome;

public class LongestPalindrome {
    int maxLength = 0;
    int k = 0;

    public String longestPalindrome(String s) {
        if (s == null) return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] cs = s.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (cs[i] == cs[j]) {
                    if (j-i>=2){
                        dp[i][j] = dp[i+1][j-1];
                    }else {
                        dp[i][j] = true;
                    }
                    if (dp[i][j]){
                        if ((j-i+1) > maxLength) {
                            maxLength = (j-i+1);
                            k = i;
                        }
                    }
                }
            }
        }

        return s.substring(k,k+maxLength);
    }
}
