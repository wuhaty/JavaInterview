package Question.leetcode;

public class Q171 {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) return 0;

        char[] cs = columnTitle.toCharArray();

        int res = 0;

        for (int i = 0; i < cs.length; i++) {
            int n = cs[i]-'A';
            res = (res*26) + n;
        }

        return res;
    }
}
