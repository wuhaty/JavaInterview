import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by gump on 2017/9/25.
 */
public class Net1 {

    public static void main(String argc[]){
        Scanner sc= new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int x = sc.nextInt();

            int base = 6;
            int factor = 0;
            base = (int)Math.pow(base,n);

            factor = dfs(n,0,factor,x);

            System.out.println(factor +"/"+base);
        }

    }

    private static int dfs(int n, int i, Integer result,int x) {
        if(i==n-1) {
            if (x>=1 && x<=6)
                return 6-x+1>6? 6:6-x+1;
            else
                return  0;
        }

        if (x<0){
            return 0;
        }

        for (int j = 1; j <=6 ; j++) {
            result = result + dfs(n,i+1,result,x-j);
        }
        return result;
    }
}
