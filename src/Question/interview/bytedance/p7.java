package Question.interview.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/5.
 */
public class p7 {
    public static void main(String argc[]){
        Scanner sc= new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String d[] = new String[n];
            for (int i = 0; i < n; i++) {
                d[i] = String.valueOf(i+1);
            }

            Arrays.sort(d);
            System.out.println(d[m-1]);
        }
    }
}
