package Question.interview.google.codeJam2017R5.pA.pB;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by gump on 2017/8/27.
 */
public class Main {
    public static double distance(int x1, int y1, int z1, int x2, int y2, int z2) {
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2) + (z1 - z2)*(z1 - z2));
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/gump/workspace/JavaInterview/src/Question/interview/google/codeJam2017R5/pA/pB/C-large.in"))));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x1, y1, z1;
            int x2, y2, z2;
            int x3, y3, z3;
            x1 = in.nextInt();
            y1 = in.nextInt();
            z1 = in.nextInt();

            x2 = in.nextInt();
            y2 = in.nextInt();
            z2 = in.nextInt();

            x3 = in.nextInt();
            y3 = in.nextInt();
            z3 = in.nextInt();
            double d1 = distance(x1, y1, z1, x2, y2, z2);
            double d2 = distance(x3, y3, z3, x2, y2, z2);
            double d3 = distance(x3, y3, z3, x1, y1, z1);
            double bigest;
            if (d1 >= d2)
                bigest = d1;
            else
                bigest = d2;
            if (d3 > bigest)
                bigest = d3;

            double answer = bigest/6;
            System.out.printf("Case #%d: %.10f\n",i,answer);
        }
        in.close();
    }
}
