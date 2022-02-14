package Question.leetcode;

import java.util.Arrays;

public class Q132_2 {

    public static void main(String[] args) {
        Q132_2 q = new Q132_2();
        q.minCut("aab");
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i == 1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }


        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (dp[0][i]){
                res[i] = 0;
            }else {
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i]){
                        res[i] = Math.min(res[i],res[j] + 1);
                    }
                }
            }
        }

        return res[n-1];
    }
}
