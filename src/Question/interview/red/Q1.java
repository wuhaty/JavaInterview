package Question.interview.red;

import java.util.Scanner;

/**
 * Created by gump on 2017/10/13.
 */
public class Q1 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            input = input.replaceAll("RED","");
            long result = -1;
            boolean flag =true;
            char c[] = input.toCharArray();
            int p=0;
            for (int i = 0; i < c.length; i++) {
                if (Character.isDigit(c[i])){
                    flag = false;
                }else{
                    if (flag){
                        p++;
                        continue;
                    }
                    long temp = Long.valueOf(input.substring(p,i));
                    if (temp > result){
                        result =temp;
                    }
                    flag = true;
                    p=i+1;
                }
            }
            System.out.println(result);
        }
    }
}
