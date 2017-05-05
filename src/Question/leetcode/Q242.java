package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/3.
 */
public class Q242 {
    public boolean isAnagram(String s, String t) {
        char str[] = s.toCharArray();
        char tar[] = t.toCharArray();

        Arrays.sort(str);
        Arrays.sort(tar);

        String stemp = new String(str);
        String ttemp = new String(tar);

        return stemp.equals(ttemp);
    }
}
