package Question.leetcode;

/**
 * Created by gump on 2021/7/11.
 */
public class Q917 {

    public static void main(String[] args) {
        Q917 q = new Q917();
        q.reverseOnlyLetters("?6C40E");
    }

    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();

        int l = 0, r= s.length()-1;

        while (l<r) {
            if (!Character.isLetter(cs[l])) {
                l++;
                continue;
            }
            if (!Character.isLetter(cs[r])) {
                r--;
                continue;
            }

            char tmp = cs[l];
            cs[l] = cs[r];
            cs[r] = tmp;

            l++;
            r--;
        }

        return new String(cs);
    }
}
