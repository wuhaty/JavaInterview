package Question.interview.netease;

import java.util.Scanner;


public class Main {


    public static void main(String argc[]){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt();
            int f = sc.nextInt();
            int d = sc.nextInt();
            int p = sc.nextInt();

            int count = 0;

            int temp = 0;

            if (f>0){
                temp = Math.min(f,d/x);
                f -= temp;
                d -= temp*x;
                count += temp;
            }
            if (d>=p && d>=x){
                temp = d/(x+p);
                d -= temp*(x+p);
                count += temp;
            }

            System.out.println(count);
        }
    }
}
