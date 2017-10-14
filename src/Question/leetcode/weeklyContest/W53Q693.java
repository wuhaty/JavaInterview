package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2017/10/13.
 */
public class W53Q693 {

    public static void main(String argc[]){
        W53Q693 q = new W53Q693();
        System.out.println(q.hasAlternatingBits(5));
        System.out.println(q.hasAlternatingBits(7));
        System.out.println(q.hasAlternatingBits(11));
        System.out.println(q.hasAlternatingBits(10));
    }

    public boolean hasAlternatingBits(int n) {
        int left = (n^(n<<1))>>1;
        int right = n^(n>>1);

        while (left>0){
            if ((left & 1) == 0) return false;
            left = (left>>1);
        }

        while (right>0){
            if ((right & 1) == 0) return false;
            right = (right>>1);
        }
        return true;
    }
}
