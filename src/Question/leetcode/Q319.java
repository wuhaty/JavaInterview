package Question.leetcode;

import java.util.Map;

/**
 * Created by gump on 2018/3/18.
 */
public class Q319 {
    public static void main(String args[]){
        Q319 q = new Q319();
        System.out.println(q.bulbSwitch(3));
    }

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public int bulbSwitchTLE(int n) {

        boolean b[] = new boolean[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = true;
        }

        int res = b.length;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j*i <= n; j++) {
                b[i*j-1] = !b[i*j-1];
            }
            if (!b[i-1]) res--;
        }
        return res;
    }
}
