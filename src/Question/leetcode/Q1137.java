package Question.leetcode;

public class Q1137 {
    public int tribonacci(int n) {
        int pre = 0;
        int next = 1;
        int cur = 1;
        if (n ==0) return 0;
        if (n ==1 || n ==2) return 1;

        int ans = 0;
        for (int i = 3; i <=n ; i++) {
            ans = pre + next + cur;
            pre = next;
            next = cur;
            cur = ans;
        }
        return ans;
    }
}
