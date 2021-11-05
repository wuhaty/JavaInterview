package Question.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/7/10.
 */
public class Q46 {

    public static void main(String[] args) {
        Q46 q = new Q46();
        int[] nums = {1,2,3};
        q.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        dfs(0,new LinkedList<>(),res,nums);

        return res;
    }

    private void dfs(int i, LinkedList<Integer> tmp, List<List<Integer>> res, int[] nums) {
        if (i>=nums.length) {
            res.add(new LinkedList<>(tmp));
        }

        for (int j = i; j < nums.length; j++) {
            Integer t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            tmp.add(nums[i]);
            dfs(i+1,tmp,res,nums);
            tmp.removeLast();
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
