package Question.interview.google.codeJam2017R3.pA;

/**
 * Created by gump on 2017/7/15.
 */
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("/Users/gump/workspace/JavaInterview/src/Question/interview/google/codeJam2017R3/pA/A-large-practice.in"))));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            Set<String> s = new HashSet<>();
            int result = recur(input,s);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int recur(String input, Set<String> s) {
        if (s.contains(input)) return 0;
        char inputArr[] = input.toCharArray();
        int n = inputArr.length;

        if (!check(inputArr)){
            return 0;
        }
        s.add(new String(inputArr));

        int sum = 0;
        int sumN = 0;

        char next[] = new char[n];
        Arrays.fill(next,'0');
        int index = 0;
        for (int i = 0; i < n ; i++) {
            if (inputArr[i] != '0'){
                sum += inputArr[i] - '0';
                for (int j = 0; j < (inputArr[i]-'0'); j++) {
                    if (index>=n) return 1;
                    next[index++] = (char) (i+1+'0');
                    sumN += next[index-1]-'0';
                }
            }
        }

        if (sum > n) {
            return 1;
        }
        if (sumN > n){
            int result = 1;
            int all = n;
            for (int i = 0; i < n; i++) {
                if (inputArr[i] != '0'){
                    result *= cnk(all,i);
                    all -= i;
                }
            }
            return 1+result;
        }

        Arrays.sort(next);

        int count = 1;

        if (n==1) return count;
        while (true){
            int i=0,j=0;
            count += recur(new String(next),s);

            for (i = n-2; i >= 0; i--) {
                if (next[i] < next[i+1]) break;
                if (i == 0) return count;
            }

            for (j =  n-1 ; j>i ; j--){
                if (next[j] > next[i]) break;
            }
            swap(next,i,j);
            reverse(next,i+1);
        }
    }

    private static int cnk(int n, int k) {
        int l = getStep(n);
        int r = getStep(n-k);

        return l/r;
    }

    private static int getStep(int k) {
        int result = 1;
        for (int i = 1; i <= k ; i++) {
            result *= i;
        }
        return result;
    }

    private static void reverse(char[] temp, int i) {
        for (int j = 0; (j+i) <= (temp.length-1+i)/2; j++) {
            swap(temp,j+i,temp.length-1-j);
        }
    }

    private static void swap(char[] temp, int i, int j) {
        char tc = temp[i];
        temp[i] = temp[j];
        temp[j] = tc;
    }

    private static boolean check(char[] inputArr) {
        boolean allZero = true;

        if (inputArr.length >9) return false;

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != '0') allZero = false;
            if ((inputArr[i]-'0') > inputArr.length) return false;
        }
        return !allZero;
    }
}
