package Question.sword;

public class O14_2 {
    public int cuttingRope(int n) {
        long res = 1;
        int mod = 1000000007;
        if (n == 1 || n ==2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        while (n>4){
            res = (res *3%mod);
            n-=3;
        }

        return (int) (res*n%mod);
    }
}
