package Question.leetcode;

/**
 * Created by gump on 2017/4/16.
 */
public class Q343 {
    public static int integerBreak(int n) {
        if(n==1) return 0;

        int dp[] = new int[n+1];
        dp[1] = 1;

        for(int j=1;j<dp.length;j++){
            for(int i=1;i<j;i++){
                dp[j] = Math.max(dp[j],Math.max(dp[j-i]*i,(j-i)*i));
            }
        }
        return dp[n];
    }

    public static void main(String argc[]){
        System.out.println(integerBreak(4));
    }
}
