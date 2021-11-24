package Question.leetcode;

public class Q7 {
    public int reverse(int x) {
        if (x == 0) return 0;

        boolean neg = (x<0);
        int res = 0;
        x = Math.abs(x);

        while (x>0) {
            int r = x %10;
            if (res > (Integer.MAX_VALUE-r)/10){
                return 0;
            }
            res = (res*10+r);
            x = x/10;
        }

        return neg?-res:res;
    }
}
