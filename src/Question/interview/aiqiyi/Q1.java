package Question.interview.aiqiyi;

import java.util.*;

/**
 * Created by gump on 2017/10/28.
 */
public class Q1 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int x[] = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }

            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                Integer num = x[i];
                char[] c = num.toString().toCharArray();
                Arrays.sort(c);
                int result = 0;
                for (int j = 0; j < c.length; j++) {
                    result= (result*10)+c[j]-'0';
                }
                temp.add(result);
            }
            Collections.sort(temp);
            System.out.println(temp.get(temp.size()-1));
        }
    }
}
