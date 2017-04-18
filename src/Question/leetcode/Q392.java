package Question.leetcode;

/**
 * Created by gump on 2017/4/16.
 */
public class Q392 {
    public static boolean isSubsequence(String s, String t) {
        if(s==null || s.equals("")) return true;
        if(t==null || t.equals("")) return false;
        boolean dp[][] = new boolean[s.length()+1][t.length()+1];
        dp[0][0] = true;
        //  for(int i=0;i<dp.length;i++) dp[i][0] = true;
        for(int i=0;i<dp[0].length;i++) dp[0][i] = true;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(t.indexOf(s.charAt(i-1))==-1){
                        return false;
                    }
                    dp[i][j] =  dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String argcp[]){
        System.out.println(isSubsequence("twn","xtxwxn"));
    }
}
