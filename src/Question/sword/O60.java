package Question.sword;

import java.util.Arrays;

public class O60 {

    public static void main(String[] args) {
        O60 q = new O60();
        q.dicesProbability(2);
    }




    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1/6.0);

        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5*i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j+k] += (dp[j] /6.0);
                }
            }
            dp = tmp;
        }

        return dp;
    }
}
