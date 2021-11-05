package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2021/9/1.
 */
public class Q40 {

    public static void main(String[] args) {
        Q40 q = new Q40();
        int d[] = {10,1,2,7,6,1,5};
        q.combinationSum2(d,8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);

        dfs(candidates, 0, target, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int sum, int target, int begin, LinkedList<Integer> es, List<List<Integer>> res) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(es));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            es.add(candidates[i]);
            dfs(candidates, sum, target, i + 1, es, res);
            sum -= candidates[i];
            es.removeLast();
        }
    }

}
