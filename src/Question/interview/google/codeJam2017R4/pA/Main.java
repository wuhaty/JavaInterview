package Question.interview.google.codeJam2017R4.pA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by gump on 2017/7/16.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/gump/workspace/JavaInterview/src/Question/interview/google/codeJam2017R3/pA/A-large-practice.in"))));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int Ts = in.nextInt();
            int Tf = in.nextInt();

            int Si[] = new int[N-1];
            int Fi[] = new int[N-1];
            int Di[] = new int[N-1];

            for (int j = 0; j < N-1; j++) {
                Si[j] = in.nextInt();
                Fi[j] = in.nextInt();
                Di[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + GoSight(N,Ts,Tf,Si,Fi,Di));
        }
    }

    private static String GoSight(int N, int Ts, int Tf, int[] Si, int[] Fi, int[] Di) {
        int dp[][] = new int[N-1][Tf];
        int max = -1;

        for (int i = 0; i < Tf; i++) {
            if ((Ts + waitBus(Ts,Si[N-2],Fi[N-2])) < i+1){
                dp[N-2][i] = 1;
            }else if (waitBus(0,Si[N-2],Fi[N-2]) < i+1){
                dp[N-2][i] = 0;
            }
        }

        if (N < 3) return Integer.toString(dp[N-2][Tf-1]);

        for (int i = N-3; i >= 0 ; i--) {
        }
        return "";
    }

    private static int waitBus(int curr, int start, int fre) {
        int i = 0;
        while (true){
            int temp = start + i* fre;
            if (temp >= curr){
                return temp - curr;
            }
        }
    }
}
