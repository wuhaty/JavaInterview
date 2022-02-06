package Question.mspractice.mock.d9;

public class q1 {
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            int t = start + 2 *i;
            ans^=t;
        }
        return ans;
    }
}
