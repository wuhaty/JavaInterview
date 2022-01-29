package Question.mspractice;

public class M1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for (int w:stones) {
            sum += w;
        }

        int t = sum/2;
        int dp[][] = new int[n+1][t+1];

        for (int i = 1; i < n+1; i++) {
            int val = stones[i-1];
            for (int j = 0; j < t+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>=val){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-val] + val);
                }
            }
        }

        return Math.abs(sum- 2*dp[n][t]);
    }
}
