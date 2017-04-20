package Question.leetcode;

/**
 * Created by gump on 2017/4/19.
 */
public class Q375 {
    public static int getMoneyAmount(int n) {
        int dp[][] = new int[n+1][n+1];

        for(int j = 2 ;j<dp[0].length;j++){
            for(int i = j-1;i>=1;i--){
                if(i==j-1){
                    dp[i][j] = i;
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for(int k =i+1;k<j;k++){
                    min = Math.min(min,Math.max(dp[i][k-1],dp[k+1][j]));
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }

    public static void main(String argc[]){
        System.out.println(getMoneyAmount(3));
    }
}
