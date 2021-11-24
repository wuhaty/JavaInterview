package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q344 {
    public String reverseString(String s) {
        char input[] = s.toCharArray();
        int lo =0;
        int hi = input.length-1;

        while (lo<hi){
            char temp = input[lo];
            input[lo] = input[hi];
            input[hi] = temp;
            lo++;
            hi--;
        }
        return new String(input);
    }

    public void reverseString(char[] s) {
        if (s == null) return;
        int l = 0, r = s.length-1;


        while (l<r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
