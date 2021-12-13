package Question.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q131 {
    boolean dp[][];
    List<List<String>> res = new LinkedList<>();
    List<String> l = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],true);
        }

        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j <n ; j++) {
                dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]);
            }
        }

        backtrack(s,0);

        return res;
    }

    private void backtrack(String s, int i) {
        if (i==s.length()) {
            res.add(new ArrayList<>(l));
            return;
        }


        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]){
                l.add(s.substring(i,j+1));
                backtrack(s,j+1);
                l.remove(l.size()-1);
            }
        }
    }
}
