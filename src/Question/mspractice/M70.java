package Question.mspractice;

public class M70 {
    public int climbStairs(int n) {
        if (n==1) return 1;
        int pre1 = 1, pre2 = 1;
        int ans = 0;
        for (int i = 2; i <=n; i++) {
            ans = pre1 + pre2;
            pre2 = pre1;
            pre1 = ans;
        }
        return ans;
    }
}
