package Question.leetcode;

public class Q1344 {

    public static void main(String[] args) {
        Q1344 q = new Q1344();
        q.angleClock(12,30);
    }



    public double angleClock(int hour, int minutes) {
        double ha = hour % 12 * 30 + (minutes+0.0)/60*30;
        double ma = (minutes+0.0)/60*360;

        double diff = Math.abs(ha-ma);

        return Math.min(360-diff,diff);
    }
}
