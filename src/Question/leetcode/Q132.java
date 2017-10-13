package Question.leetcode;

/**
 * Created by gump on 2017/5/23.
 */
public class Q132 {

    public static void main(String argc[]){
        Q132 q = new Q132();
        q.minCut921("cbbbcc");
    }


    public int minCut921(String str){
        if (str.isEmpty()) return 0;

        int n = str.length();
        char s[] = str.toCharArray();
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int cut[] = new int[n];

        for (int i = 1; i < n; i++) {
            cut[i] = cut[i-1] +1;
            for (int j = 0; j < i; j++) {
                if (s[i] == s[j] && (i==(j+1) || dp[j+1][i-1])){
                    dp[j][i] = true;
                    cut[i] = Math.min(cut[i],Math.min(j==0?0:cut[j-1]+1,dp[0][j]?cut[j]+1:Integer.MAX_VALUE));
                }
            }
        }

        return cut[n-1];
    }

    public int minCutNice(String str) {
        int n = str.length();
        char s[] = str.toCharArray();
        int cut[] =new int[n + 1];
        for (int i = 0; i <= n; i++) cut[i] = i - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s[i - j] == s[i + j]; j++) // odd length palindrome
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);

            for (int j = 1; i - j + 1 >= 0 && i + j < n && s[i - j + 1] == s[i + j]; j++) // even length palindrome
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
        }
        return cut[n];
    }

    public int minCut(String s) {
        if (s.isEmpty()) return 0;

        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int d[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            d[i] = n - i - 1;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)
                        && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j == n - 1) {
                        d[i] = 0;
                    } else if (d[j + 1] + 1 < d[i]) {
                        d[i] = d[j + 1] + 1;
                    }
                }
            }
        }

        return d[0];
    }
}
