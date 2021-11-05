package Question.leetcode;

/**
 * Created by gump on 2021/7/11.
 */
public class Q69 {

    public static void main(String[] args) {
        Q69 q = new Q69();
        q.mySqrt(8);
    }


    //k^2 > x , then k must > sqrt(x) , so track every k which < x.
    public int mySqrt(int x) {
        int l = 0, r = x;
        int ans = -1;
        while (l<=r) {
            int mid = l + (r - l) / 2;

            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
