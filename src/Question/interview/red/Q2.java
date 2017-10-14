package Question.interview.red;

import java.util.Scanner;

/**
 * Created by gump on 2017/10/13.
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {//注意while处理多个case
            int n = sc.nextInt();
            int input[] = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            int dp[] = new int[n];
            int max = 0;
            int zero = dp[0]==0?1:0;
            int one = dp[0]==1?1:0;

            for (int i = 1; i < n; i++) {
                if (input[i] == 0) {
                    zero++;
                } else {
                    one++;
                }
                if(zero == one){
                    dp[i] = 2 * Math.min(zero, one);
                }else{
                    dp[i] = dp[i-1];
                }

                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}
