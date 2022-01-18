package Question.leetcode;

/**
 * Created by gump on 2017/5/17.
 */
public class Q10 {

    public static void main(String argc[]){
        Q10 q = new Q10();
//        q.isMatch2021("fas","f.*as");
//        q.isMatch2021("mississippi","mis*is*p*.");
        q.isMatch2021("aab","c*a*b");
    }

    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i-1) == '*'){
                dp[i][0] = i > 1 && dp[i - 2][0];
            }else {
                dp[i][0] = false;
            }
        }

        for (int i = 1; i <= p.length() ; i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i-1) == '*'){
                    if(i==1){
                        dp[i][j]= s.isEmpty();
                    }else if (p.charAt(i-2)=='.'|| p.charAt(i-2) == s.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1] ||  dp[i-2][j];
                    }else{
                        dp[i][j] = dp[i-2][j];
                    }
                }else{
                    if(p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public boolean isMatch2021Wrong(String s, String p) {
        //CANNOT MATCH THE * CASE , CUZ IT COULD BE MATCHED TO 0 ~ ANY LENGTH
        if (s == null) return false;
        char[] cs = s.toCharArray();
        char[] pcs = p.toCharArray();
        int i = 0,j = 0;
        Character pre = null;
        while (i < s.length() && j < p.length()){
            char pinput = pcs[j];

            if (pinput == '.'){
                pre = '.';
                j++;
                i++;
            }else if (pinput == '*'){
                while (i<s.length() && (pre == '.' || pre == cs[i])){
                    i++;
                }
                j++;
            }else if (j+1 < p.length() && pcs[j+1] == '*'){
                pre = pcs[j];
                j++;
            }else {
                if (cs[i] != pcs[j]) {
                    return false;
                }
                pre = pcs[j];
                j++;
                i++;
            }
        }

        return i == s.length() && j == p.length();
    }

    public boolean isMatch2021(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c = p.charAt(j-1);
                if (c == '*') {
                    if (i!=0 && match(s.charAt(i-1),p.charAt(j-2))){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }else {
                    if (i!=0 && match(s.charAt(i-1),c)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }

    private boolean match(char s, char p) {
        if (p =='.') return true;

        return s == p;
    }
}
