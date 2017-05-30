package Question.interview.indeed;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by gump on 2017/5/27.
 */
public class RoomNumber {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[m];

        int max = 0;
        LinkedHashSet<Integer> numValid = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max = Math.max(max,a[i]);
        }

        for (int i = 1; i <= max; i++) {
            numValid.add(i);
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            numValid.remove(b[i]);
            numValid.add(++max);
        }

        for (int i = 0; i < n; i++) {
            int rooms = a[i];
            int j = 0;
            for (int roomNum:numValid) {
                if (++j == rooms){
                    System.out.println(roomNum);
                    System.out.flush();
                    break;
                }
            }
        }
    }
}
