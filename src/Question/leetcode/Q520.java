package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q520 {
    public boolean detectCapitalUse(String word) {
        char input[] = word.toCharArray();
        if (word.length()==1) return true;

        if (judge(input[0])) {
            for (int i = 1; i < input.length; i++) {
                if (!judge(input[i])) return false;
            }
        } else {
            boolean capital = judge(input[1]);
            for (int i = 2; i < input.length; i++) {
                if (judge(input[i]) != capital) return false;
            }
        }
        return true;
    }

    private boolean judge(char c) {
        return c >= 'a' && c <= 'z';
    }
}
