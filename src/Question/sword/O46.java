package Question.sword;

import java.util.HashMap;
import java.util.Map;

public class O46 {
    Map<Integer,Integer> m = new HashMap<>();

    public static void main(String[] args) {
        O46 q = new O46();
        q.translateNum(9999);
    }

    public int translateNum(int num) {
        String str = String.valueOf(num);

        int p = 1, q = 0, res = 1;
        for (int i = 1; i < str.length(); i++) {
            q = p;
            p = res;
            String sub = str.substring(i-1,i+1);
            if (sub.compareTo("10")>=0 && sub.compareTo("26")<0){
                res = p +q ;
            }
        }

        return res;
    }
}
