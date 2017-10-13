package Question.interview.bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/2.
 */
public class p2 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            ArrayList<Long> container = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int op = sc.nextInt();
                if (op == 1){
                    container.add(sc.nextLong());
                }else{
                    container.remove(sc.nextLong());
                }
                System.out.println(judge(container));
            }
        }
    }

    private static String judge(ArrayList<Long> container) {
        if (container.size()<=2) return "No";

        long sum = 0;
        for (int i = 0; i < container.size(); i++) {
            sum+= container.get(i);
        }

        for (int i = 0; i < container.size(); i++) {
            if (sum-container.get(i) <= container.get(i)) return "No";
        }
        return "Yes";
    }
}
