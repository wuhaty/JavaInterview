package Question.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Q139 {
    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[][] =new boolean[s.length()+1][s.length()+1];
        dp[0][0] = true;

        for (int i = s.length(); i >=1; i--) {
            for (int j = i; j <= s.length(); j++) {
                String temp = s.substring(i-1,j);
                if(wordDict.contains(temp)){
                    dp[i][j] = true;
                }else{
                    for (int k = s.length(); k >=0 ; k--) {
                        if(dp[k][j]){
                            dp[i][j] = dp[i][j] || dp[i][k-1];
                        }
                    }
                }
            }
        }

        return dp[1][s.length()];
    }

    public static  void main(String argc[]){
        List<String> list =new ArrayList<>();
        list.add("dog");
        list.add("s");
        list.add("gs");
        System.out.println(wordBreak("dogs",list));
    }
}
