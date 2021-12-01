package Question.leetcode;

import java.util.ArrayList;
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

    public List<List<Integer>> permute2021(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        backtrack(res,nums,0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> l = new ArrayList<>(nums.length);
            for (int n:nums) {
                l.add(n);
            }
            res.add(l);
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums,i,j);
            backtrack(res,nums,i+1);
            swap(nums,i,j);
        }
    }

    private void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
