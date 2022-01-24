package Question.sword;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class O49 {
    public int nthUglyNumberQueue(int n) {
        int[] factors = {2,3,5};
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.offer(1L);
        Set<Long> visited = new HashSet<>();
        Long ugly = 0L;

        while (n-- > 0){
            ugly = q.poll();
            for (int f:factors) {
                long next = f*ugly;
                if (!visited.contains(next)){
                    visited.add(f*ugly);
                    q.offer(next);
                }
            }
        }

        return ugly.intValue();
    }


    public int nthUglyNumber(int n) {
        int p2 = 1,p3 = 1,p5 = 1;
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2,Math.min(num3,num5));

            if (dp[i] == num2){
                p2 ++;
            }

            if (dp[i] == num3){
                p3 ++;
            }

            if (dp[i] == num5){
                p5 ++;
            }
        }

        return dp[n];
    }
}
