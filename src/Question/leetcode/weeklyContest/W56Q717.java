package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2017/10/31.
 */
public class W56Q717 {
    public static void main(String argc[]){
        int bits[] = {0, 0, 0};
        W56Q717 q =new W56Q717();
        System.out.println(q.isOneBitCharacter(bits));
    }
    public boolean isOneBitCharacter(int[] bits) {
        return helper(bits,bits.length-2);
    }

    private boolean helper(int[] bits, int i) {
        if (i<0) return true;
        if (i==0){
            if (bits[i] == 0){
                return true;
            }else{
                return false;
            }
        }
        if (bits[i] == 0){
            if (bits[i-1]==1) return helper(bits,i-2) || helper(bits,i-1);
            else return helper(bits,i-1);
        }else{
            if (bits[i-1]==1) return helper(bits,i-2);
            else return false;
        }
    }
}
