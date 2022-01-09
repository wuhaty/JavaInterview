package Question.sword;

public class O10_2 {
    public int numWays(int n) {
        int MOD = 1000000007;
        if (n < 2) return 1;


        int x = 2;
        int p = 1;
        int q = 1;
        int res = 0;
        while (x <= n) {
            res = (p+q)%MOD;
            q = p;
            p = res;
            x++;
        }
        return res;
    }
}
