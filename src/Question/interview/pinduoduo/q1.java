package Question.interview.pinduoduo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/24.
 */
public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int tmin = sc.nextInt();
                int tmax = sc.nextInt();

                for (int j = tmin; j <= tmax; j++) {
                    if (map.containsKey(j)) {
                        int temp = map.get(j);
                        map.put(j, temp + 1);
                    } else {
                        map.put(j, 1);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int key : map.keySet()) {
                if (map.get(key) >= k) {
                    if (key < min) min = key;
                    if (key > max) max = key;
                }
            }
            if (min==Integer.MAX_VALUE && max==Integer.MIN_VALUE){
                System.out.println("error");
            }else{
                System.out.print(min);
                System.out.print(" ");
                System.out.println(max);
            }
        }
    }
}
