package Question.interview.pinduoduo;

import java.util.*;

/**
 * Created by gump on 2017/10/24.
 */
class Bear{
    int power;
    int hunger;
}
public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> candy = new LinkedList<>();
            List<Bear> bears = new LinkedList<>();
            List<Integer> bearspower = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                candy.add(sc.nextInt());
            }
            for (int i = 0; i <n ; i++) {
                Bear bear = new Bear();
                bear.power = sc.nextInt();
                bear.hunger = sc.nextInt();
                bears.add(bear);
                bearspower.add(bear.power);
            }

            Collections.sort(candy, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return (o2-o1);
                }
            });

            Collections.sort(bears,new Comparator<Bear>() {
                @Override
                public int compare(Bear o1, Bear o2) {
                    return (o2.power-o1.power);
                }
            });


            while (true){
                boolean flag = true;
                for (int i = 0; i < bears.size(); i++) {
                    Bear cur = bears.get(i);
                    for (int j = 0; j < candy.size()&&cur.hunger>0; j++) {
                        int c = candy.get(j);
                        if (c<= cur.hunger) {
                            cur.hunger-=c;
                            candy.remove(Integer.valueOf(c));
                            j--;
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) break;
            }

            for (Integer power:bearspower) {
                for (Bear bear:bears) {
                    if (bear.power==power) System.out.println(bear.hunger);
                }
            }
        }
    }
}
