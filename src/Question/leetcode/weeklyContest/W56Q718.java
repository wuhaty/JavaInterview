package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2017/11/7.
 */
public class W56Q718 {

    public static void main(String argc[]){
        W56Q718 q= new W56Q718();
        int a[] = {1,2,3,2,1};
        int b[] = {3,2,1,4,7};
        q.findLength(a,b);
    }


    public int findLength(int[] A, int[] B) {
        int dp[][] = new int[A.length+1][B.length+1];
        int result =0;
        for (int i = 1; i <=A.length; i++) {
            for (int j = 1; j <=B.length; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
                result = Math.max(result,dp[i][j]);
            }
        }

        return result;
    }
}
