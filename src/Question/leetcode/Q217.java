package Question.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gump on 2017/5/10.
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (s.contains(i)){
                return true;
            }
            s.add(i);
        }
        return false;
    }
}
