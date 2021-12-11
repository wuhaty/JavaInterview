package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int dp[][] = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        Map<Integer,Integer> m = new HashMap<>();
        m.put(arr[0],0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = 1;
            int pre = arr[i]-difference;
            if (m.containsKey(pre)) {
                dp[i][1] = Math.max(dp[m.get(pre)][1] +1,dp[i][1]);
            }
            m.put(arr[i],i);
        }

        return Math.max(dp[n-1][0],dp[n-1][1]);
    }


    public int longestSubsequenceOptimzed(int[] arr, int difference) {
        int n = arr.length;

        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(arr[0],0);
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i],m.getOrDefault(arr[i]-difference,0)+1);
            max = Math.max(max,m.get(arr[i]));
        }

        return max;
    }
}
