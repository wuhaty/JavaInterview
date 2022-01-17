package Question.sword;

import java.util.HashMap;
import java.util.Map;

public class O16 {
    Map<Integer,Double> m = new HashMap<>();

    public static void main(String[] args) {
        O16 q = new O16();
        q.myPow(0.44528,0);
    }

    public double myPow(double x, int n) {
        if (m.containsKey(n)) return m.get(n);
        if (n==0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1/x;

        double res = myPow(x,n/2);
        m.put(n/2,res);
        if (n%2==0) {
            return res*res;
        }else {
            return n>0?res*res*x:res*res/x;
        }
    }


    public double myPow2021(double x, int n) {
        int b = n;
        if (n < 0) {
            x = 1/x;
            b = -b;
        }

        double res = 1;
        while (b>0){
            if ((b & 1) ==1) res *= x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}
