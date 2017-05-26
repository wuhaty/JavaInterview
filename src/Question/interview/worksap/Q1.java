package Question.interview.worksap;

/**
 * Created by gump on 2017/5/25.
 */
import java.math.BigDecimal;
import java.util.Scanner;

public class Q1 {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(solve(m, n));
    }

    public static int solve(int m, int n) {
        if (n<=0) return 0;
        if (m==1) return 1;

        double sum = Math.pow(m,n-1) - Math.pow(m-1,n-1);
        double result = m * sum;

        return (int)result%100003;
    }
}
