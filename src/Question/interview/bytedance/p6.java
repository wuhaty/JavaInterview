package Question.interview.bytedance;

import java.util.Scanner;

/**
 * Created by gump on 2017/10/5.
 */
public class p6 {
    public static void main(String argc[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int d[] = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if ((d[i]^d[j]) >m){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
