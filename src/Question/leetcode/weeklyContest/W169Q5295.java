package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2019/12/29.
 */
public class W169Q5295 {
    public int[] sumZero(int n) {
        int res[] = new int[n];
        int end= n;
        if (n %2 != 0) {
            res[n-1] = 0;
            end = n-1;
        }

        int k =1;
        for (int i = 0; i < end; i++) {
            if (i %2 == 0) {
                res[i] = k;
            }
            else  {
                res[i] = -k;
                k++;
            }
        }


        return res;
    }
}
