package Question.interview.aiqiyi;

/**
 * Created by gump on 2017/10/28.
 */
import java.util.Scanner;
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String s = in.next();
            minBrace(s);
        }
    }

    public static void minBrace(String s) {

        int size = s.length();
        // we begin with mb[1][1]
        int[][] mb = new int[size + 1][size + 1];
        for(int i = 1; i <= size; ++i){
            mb[i][i] = 1;
        }

        // d refers to the distance between i and j, that is d = j - i
        for(int d = 1; d < size; d++){
            for (int i = 1; i + d <= size; i++) {
                int j = i + d;
                // the worst case
                mb[i][j] = Math.min(mb[i][j - 1], mb[i + 1][j]) + 1;
                // the case in which a char between i and j (= i + d) matches
                // the character at position j + 1
                for (int k = i ; k <= j - 1; k++ ) {
                    if (match(s.charAt(k - 1), s.charAt(j - 1))) {
                        mb[i][j] = Math.min(mb[i][j], mb[i][k - 1] + mb[k + 1] [j - 1]);
                    }
                }
            }
        }

        System.out.println(mb[1][size]);
    }

    static boolean match(char a, char b){
        if(a == '(' && b == ')')
            return true;
        if(a == '[' && b == ']')
            return true;
        return false;
    }
}
