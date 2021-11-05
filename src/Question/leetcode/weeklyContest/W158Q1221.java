package Question.leetcode.weeklyContest;

public class W158Q1221 {
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int res = 0;
        for (char c:s.toCharArray()) {
            if (c == 'L') l++;
            if (c == 'R') r ++;

            if (l == r) {
                res++;
                l = 0;
                r = 0;
            }
        }
        return res;
    }
}
