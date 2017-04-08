package Question.leetcode;

/**
 * Created by gump on 2017/4/8.
 */
public class Q474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for(String str:strs){
            int count0 = count(str,'0');
            int count1 = count(str,'1');

            for(int i=m;i>=count0;i--){
                for(int j=n;j>=count1;j--){
                    dp[i][j] = Math.max(dp[i][j],1+dp[i-count0][j-count1]);
                }
            }
        }
        return dp[m][n];
    }

    public int count(String s,char c){
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c) result ++;
        }
        return result;
    }

    public static void main(String argc[]){
        Q474 q = new Q474();
        String d[] = {"10", "0001", "111001", "1", "0"};
        System.out.println(q.findMaxForm(d,5,3));
    }
}
