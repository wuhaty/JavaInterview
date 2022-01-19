package Question.sword;

public class O14 {
    public int cuttingRope(int n) {
        if (n<2) return 1;
        int[] dp = new int[n+1];

        dp[2] = 1;
        for (int i = 3; i <=n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }

        return dp[n];
    }

    public int cuttingRopeMath(int n) {
        if (n<2) return 1;
        if (n==3) return 2;
        if (n==4) return 4;

        int res = 1;
        while (n>4) {
            res *=3;
            n-=3;
        }

        return res*n;
    }
}
