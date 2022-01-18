package Question.leetcode;

public class Q32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        int[] dp = new int[s.length()];


        for (int i = 1; i < s.length(); i++) {
            if (cs[i] == ')'){
                if (cs[i-1]== '('){
                    dp[i] = i>=2? dp[i-2]+2:2;
                }else if (i-dp[i-1] >0 && cs[i-dp[i-1] - 1]=='('){
                    dp[i] = dp[i-1] + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0) +2;
                }
            }

            res = Math.max(dp[i],res);
        }
        return res;
    }

}
