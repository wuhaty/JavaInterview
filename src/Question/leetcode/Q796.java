package Question.leetcode;

/**
 * Created by gump on 2018/3/16.
 */
public class Q796 {
    public boolean rotateString(String A, String B) {
        return (A + A).contains(B);
    }
}
