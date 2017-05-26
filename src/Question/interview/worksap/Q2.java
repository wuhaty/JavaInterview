package Question.interview.worksap;

/**
 * Created by gump on 2017/5/25.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Q2 {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        int data[] = new int[n];
//        int i =0;
//        while (in.hasNext()){
//            data[i++] = in.nextInt();
//        }
        int data[] = {1,1,1,1,1,1,9};
        System.out.println(solve(7, 7,data));
    }

    public static String solve(int m, int n, int[] data) {
        Arrays.sort(data);
        long sum = 0;

        for (int i :data) {
            sum += i;
        }

        int k = 1;
        while (m*k <= sum){
            boolean dp[][] =new boolean[n][m*k+1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m*k+1; j++) {
                    if (j<data[i]){
                        dp[i][j] = i != 0 && dp[i-1][j];
                    }else{
                        dp[i][j] = i != 0 && (dp[i - 1][j] || dp[i - 1][j - data[i]]);
                    }
                    if(j==m*k && dp[i][j]) return "Yes";
                }
            }
            k++;
        }
        return "No";
    }
}
