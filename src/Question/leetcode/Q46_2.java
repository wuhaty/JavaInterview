package Question.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q46_2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        backtrack(res,0,l,nums);

        return res;
    }

    private void backtrack(List<List<Integer>> res, int i, List<Integer> l, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(l));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            l.add(nums[j]);
            swap(nums,i,j);
            backtrack(res,i+1,l,nums);
            swap(nums,i,j);
            l.remove(l.size()-1);
        }
    }

    public void swap(int[] nums, int l ,int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
