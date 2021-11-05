package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2019/2/17.
 */
public class W123Q991 {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (X < Y){
            if (Y %2 ==0) {
                Y/=2;
            }else{
                Y++;
            }
            count++;
        }
        return (X-Y) + count;
    }
}
