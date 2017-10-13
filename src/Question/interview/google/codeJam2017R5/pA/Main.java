package Question.interview.google.codeJam2017R5.pA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by gump on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/gump/workspace/JavaInterview/src/Question/interview/google/codeJam2017R5/pA/A-large.in"))));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String input = in.next();
            String clipBoard = "";
            StringBuilder buffer = new StringBuilder();
            int count = 0;
            int j =0;
            while (j<input.length()) {
                int step =2;
                int score = 0;
                while (j+step<=input.length() && buffer.indexOf(input.substring(j,j+step)) != -1){
                    step++ ;
                }

                String concat = input.substring(j,j+step-1);
                if (clipBoard.equals(concat)){
                    score = 1;
                }else if(step-1 >=2){
                    clipBoard = concat;
                    score = 2;
                }else{
                    score = concat.length();
                }
                j+=concat.length();
                buffer.append(concat);
                count += score;
            }
            System.out.printf("Case #%d: %d\n",i+1,count);
        }
        in.close();

    }
}
