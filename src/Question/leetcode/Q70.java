package Question.leetcode;

/**
 * Created by gump on 2021/7/21.
 */
public class Q70 {
    public static void main(String[] args) {
        Q70 q = new Q70();

        System.out.print(q.climbStairs(3));
    }


    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int p = 1;
        int q = 1;
        int i = 2;
        int res = 0;

        while (i<=n){
            res = (p+q);

            p = q;
            q = res;
            i++;
        }


        return res;
    }

    public int climbStairs2021(int n) {
        int p = 1;
        int q = 1;
        if (n==1) return p;
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = p + q;
            p = q;
            q= sum;
        }
        return sum;
    }
}
