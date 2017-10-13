package Question.interview.didi;

/**
 * Created by gump on 2017/9/23.
 */
import java.math.BigDecimal;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            BigDecimal r = in.nextBigDecimal();
            int n = in.nextInt();
            System.out.println(r.pow(n).toPlainString());
        }
    }
}
