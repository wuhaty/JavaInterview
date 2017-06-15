package Question.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Q139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }


    public static boolean wordBreakOri(String s, List<String> wordDict) {

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
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode",list));
    }
}
