package Question.mspractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M139 {
    public static void main(String[] args) {
        M139 m = new M139();
        m.wordBreakOPT("leetcode", Arrays.asList("leet","code"));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> avail = new HashSet<>(wordDict);
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        dp[0][0] = true;

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <=n ; j++) {
                String left = s.substring(i-1,j);
                dp[i][n] |= ((left.equals("") || avail.contains(left)) && (j + 1 > n || dp[j + 1][n]));
            }
        }
        return dp[1][n];
    }

    public boolean wordBreakOPT(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> avail = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n +1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && avail.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}
