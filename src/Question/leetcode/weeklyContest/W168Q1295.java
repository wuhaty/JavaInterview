package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2019/12/25.
 */
public class W168Q1295 {
    public int findNumbers(int[] nums) {
        int res = 0;

        for (int k:nums) {
            if (judge(k)) res ++;
        }
        return res;
    }

    private boolean judge(int k) {
        return String.valueOf(k).length() %2 ==0;
    }
}
