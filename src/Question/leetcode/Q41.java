package Question.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q41 {


    public static void main(String args[]){
        Q41 q = new Q41();
        int[] t = {1,1000};
        System.out.print(q.firstMissingPositive(t));

    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length ==0) return 1;

        List<Integer> l = new LinkedList<>();

        for (int i : nums) {
            l.add(i);
        }

        Collections.sort(l);
        int init = -1;
        for (int i = 0; i < l.size(); i++) {
            Integer cur = l.get(i);
            if (cur <=0) continue;
            else {
                if (init == -1 && cur != 1) return 1;
                else {
                    if (init == -1) init = i;
                    else {
                        if (cur - l.get(init) == 0 || cur - l.get(init) == 1) {
                            init = i;
                        } else return l.get(init)+1;
                    }
                }
            }
        }
        return init==-1? 1: l.get(l.size()-1) + 1;
    }
}
