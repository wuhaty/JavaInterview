package Question.leetcode.weeklyContest;

public class W267Q2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;

        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    //needs to buy a ticket
                    tickets[i] --;
                    res ++;
                    if (i == k && tickets[k] ==0) return res;
                }
            }
        }

        return res;
    }
}
