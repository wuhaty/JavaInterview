package Question.mspractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M46 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new LinkedList<>();
        backtrack(nums,0,l);
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> l) {
        if (i == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums,i,j);
            l.add(nums[i]);
            backtrack(nums,i+1,l);
            l.remove(l.size()-1);
            swap(nums,i,j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
