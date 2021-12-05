package Question.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2017/8/22.
 */
public class Q39 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,0,target,new LinkedList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int index,int target, LinkedList<Integer> l) {
        if (target<0 || index>=candidates.length) return;
        if (target == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        backtrack(candidates,index+1,target,l);

        if (target-candidates[index]>0) {
            l.add(candidates[index]);
            backtrack(candidates, index, target - candidates[index], l);
            l.remove(l.size() - 1);
        }
    }
}