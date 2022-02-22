package Question.mspractice;

import java.util.Arrays;

public class M887 {
    Integer dp[][];
    public int superEggDrop(int k, int n) {
        dp = new Integer[k+1][n+1];
        for (int j = 0; j <= n; j++) {
            dp[1][j] = j;
            dp[0][j] = 0;
        }

        for (int i = 1; i <= k; i++) {
            dp[i][0] = 0;
        }

        helper(k,n);
        return dp[k][n];
    }

    private Integer helper(int k, int n) {
        if (dp[k][n] != null) return dp[k][n];
        if (k == 1) return n;

        int min = n;

        int lo = 1, hi = n , t = 0;

        while (lo<=hi){
            int mid = lo + (hi - lo)/2;

            int t1 = helper(k-1,mid-1);
            int t2 = helper(k,n-mid);

            t = Math.max(t1,t2) +1;
            if (t1>t2){
                hi = mid-1;
            }else {
                lo = mid+1;
            }
            min = Math.min(min,t);
        }

        dp[k][n] = min;
        return min;
    }

    public int superEggDropDP(int k, int n) {
        int[][] ans = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[1][0] = 0;

        for (int i = 1; i <= n; i++) ans[i][1] = i;
        for (int i = 1; i <= k; i++) ans[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
//                for (int cur = 1; cur <= i; cur++) {
//                    ans[i][j] = Math.min(ans[i][j],1 + Math.max(ans[cur-1][j-1],ans[i-cur][j]));
//                }

                int l = 1, r = i, max = 0;
                while (l<=r){
                    int mid = (l+r)/2;

                    int t1 = ans[mid-1][j-1];
                    int t2 = ans[i-mid][j];

                    if (t1>=t2){
                        max = t1;
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }

                ans[i][j] = Math.min(ans[i][j],1+max);
            }
        }

        return ans[n][k];
    }

}
