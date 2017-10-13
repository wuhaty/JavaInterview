package Question.interview.bytedance;

import java.util.Scanner;

/**
 * Created by gump on 2017/10/2.
 */
public class p4 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int x = sc.nextInt();
            int k = sc.nextInt();
            StringBuilder xstr = new StringBuilder(Integer.toBinaryString(x));
            StringBuilder result = new StringBuilder();
            char kstr[] = Integer.toBinaryString(k).toCharArray();

            int i= xstr.length()-1,j=kstr.length-1;

            while (j>=0){
                if (i<0){
                    xstr.insert(0,'0');
                    i=0;
                    continue;
                }
                if (xstr.charAt(i)=='1'){
                    result.insert(0,'0');
                }else{
                    result.insert(0,kstr[j--]);
                }
                i--;
            }
            System.out.print(Long.valueOf(result.toString(),2));
        }
    }
}
