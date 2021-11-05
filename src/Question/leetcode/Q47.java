package Question.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/9/1.
 */
public class Q47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        dfs(res,nums,new LinkedList<>(),visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, LinkedList<Integer> es, boolean[] visited) {
        if (es.size() == nums.length) {
            res.add(new ArrayList<>(es));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i>0 && nums[i]==nums[i-1] && visited[i-1])) continue;

            visited[i] = true;
            es.add(nums[i]);
            dfs(res,nums,es,visited);
            es.removeLast();
            visited[i] = false;

        }
    }

//    private void dfs(List<List<Integer>> res,int[] nums, LinkedList<Integer> es) {
//
//        for (int j = i; j < nums.length; j++) {
//            if (i>0 && nums[i] == nums[i - 1] ) {
//                continue;
//            }
//
//            int t = nums[i];
//            nums[i] = nums[j];
//            nums[j] = t;
//            es.add(nums[j]);
//            dfs(res,j+1,nums,es);
//            t = nums[i];
//            nums[i] = nums[j];
//            nums[j] = t;
//            es.removeLast();
//        }
//    }

}
