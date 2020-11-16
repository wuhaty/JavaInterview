package Question.leetcode;

/**
 * Created by gump on 2018/3/21.
 */
public class Q801 {

    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int swap[] = new int[n];
        int nswap[] = new int[n];
        swap[0] = 1;

        for (int i = 1; i < n; i++) {
            swap[i] = n;
            nswap[i] = n;

            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                nswap[i] = nswap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }

            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                nswap[i] = Math.min(nswap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], nswap[i - 1] + 1);
            }
        }

        return Math.min(swap[n - 1], nswap[n - 1]);
    }
}
