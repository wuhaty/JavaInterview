package Question.leetcode;

/**
 * Created by gump on 2017/6/13.
 */
public class Q97 {

    public static void main(String argc[]) {
        Q97 q = new Q97();
        System.out.println(q.isInterleave("a", "", "a"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean dp[][] = new boolean[s2.length() + 1][s1.length() + 1];

        for (int i = 0; i < s2.length()+1; i++) {
            for (int j = 0; j < s1.length()+1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[0][j - 1] && s1.charAt(j-1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][0] && s2.charAt(i-1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = dp[i][j - 1] && s1.charAt(j-1) == s3.charAt(i + j - 1)
                            || dp[i - 1][j] && s2.charAt(i-1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s2.length()][s1.length()];
    }


    public boolean isInterleaveOri(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3);
    }

    private boolean dfs(String s1, String s2, String s3) {
        if (s3.isEmpty() || s3 == null) {
            return true;
        }

        if (s1 != null && !s1.isEmpty()
                && s2 != null && !s2.isEmpty()
                && s1.charAt(0) == s2.charAt(0)
                && s1.charAt(0) == s3.charAt(0)) {

            return dfs(s1.substring(1), s2, s3.substring(1)) || dfs(s1, s2.substring(1), s3.substring(1));
        } else {

            if (s1 != null && !s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
                return dfs(s1.substring(1), s2, s3.substring(1));
            }

            if (s2 != null && !s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) {
                return dfs(s1, s2.substring(1), s3.substring(1));
            }
        }

        return false;
    }
}
