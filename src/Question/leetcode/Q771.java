package Question.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gump on 2018/1/28.
 */
public class Q771 {
    public int numJewelsInStones(String J, String S) {
        char jewel[] = J.toCharArray();
        Set<Character> jewset = new HashSet<>();
        for (Character c:jewel) {
            jewset.add(c);
        }
        int result = 0;
        for (Character c:S.toCharArray()) {
            if (jewset.contains(c))result++;
        }
        return result;
    }
}
