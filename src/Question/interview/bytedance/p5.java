package Question.interview.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/5.
 */
public class p5 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int d[] = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
            }

            Arrays.sort(d);
            int count = 0;
            int group = 1;

            for (int i = 1; i < n; i++) {
                if (group<3){
                    if (d[i]-d[i-1]<=10){
                        group++;
                        continue;
                    }else{
                        count += (3-group);
                        group=1;
                    }
                }else{
                    group = 1;
                }
            }

            count += (3-group);
            System.out.println(count);
        }
    }
}
