package Question.leetcode;

/**
 * Created by gump on 2017/5/6.
 */
public class Q5 {

    int maxLength = 0;
    int k = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            explore(s,i,i);
            explore(s,i,i+1);
        }
        return s.substring(k,k+maxLength);
    }

    public void explore(String s ,int i,int j){
        while (i>=0
                && j<s.length()
                && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }

        if((j-i-1)>maxLength){
            maxLength=(j-i-1);
            k=i+1;
        }
    }


    public String longestPalindromeDP(String s) {
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

    public static void main(String[] args) {
        Q5 q = new Q5();
        q.longestPalindromeDP("aaaa");
    }

    public String longestPalindrome2021(String s) {
        if (s==null) return s;

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            expand(cs,i,i);
            expand(cs,i,i+1);
        }

        return s.substring(k,k+maxLength);
    }

    private void expand(char[] cs, int l, int r) {
        while (l>=0 && r<cs.length && l<=r && cs[l] == cs[r]){
            if (r-l +1>maxLength) {
                k=l;
                maxLength = (r-l+1);
            }
            l--;
            r++;
        }
    }

}
