package Question.sword;

public class O66 {

    public int[] constructArrOOM(int[] a) {
        int[][] dp = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            dp[i][i] = a[i];
            for (int j = i+1; j < a.length; j++) {
                dp[i][j] = dp[i][j-1] * a[j];
            }
        }

        int[] res = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int left = (i-1)>=0?dp[0][i-1]:1;
            int right = (i+1)<a.length?dp[i+1][a.length-1]:1;
            res[i] = left*right;
        }

        return res;
    }


    public int[] constructArr(int[] a) {
        if (a==null || a.length == 0) return a;
        int[] res = new int[a.length];

        int tmp =1;
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i-1]*a[i-1];
        }

        for (int i = a.length-2; i >=0 ; i--) {
            tmp *= a[i+1];
            res[i] *= tmp;
        }

        return res;
    }
}
