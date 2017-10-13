package Question.interview.netease;

import java.util.Scanner;


public class Main2 {
    public static void main(String argc[]){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int x[] = new int[n];
            int y[] = new int[n];
            for (int i = 0 ;i<n;i++){
                x[i] = sc.nextInt();
            }
            for (int i = 0 ;i<n;i++){
                y[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (i==0){
                    System.out.print(0);
                    System.out.print(' ');
                    continue;
                }

                int sumx = 0;
                int sumy = 0;
                int avgx = 0;
                int avgy = 0;
                for (int j = 0; j <= i; j++) {
                    sumx += x[j];
                    sumy += y[j];
                }
                avgx = sumx/(i+1);
                avgy = sumy/(i+1);
                int op = 0;
                for (int j = 0; j <= i; j++) {
                    op += Math.abs(avgx - x[j]);
                    op += Math.abs(avgy - y[j]);
                }
                if (i==n-1){
                    System.out.println(op);
                }else{
                    System.out.print(op);
                    System.out.print(' ');
                }
            }
        }
    }
}
