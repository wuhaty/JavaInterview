package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2019/9/28.
 */
public class W155Q1201 {

    public static void main(String args[]){
        W155Q1201 q = new W155Q1201();
        q.nthUglyNumber(1000000000,2,217983653,336916467);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int i=1,j=1,k=1, res=0;

        for (int l = 0; l < n;) {
            int ai = i * a;
            int bj = j * b;
            int ck = k * c;

            res = Math.min(Math.min(ai,bj),ck);

            if (res == ai) {
                i ++; l++;
            }
            if (res == bj){
                j ++; l++;
            }
            if (res == ck) {
                k ++; l++;
            }
        }
        return res;
    }
}
