package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/8/17.
 */
public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        dfs(root,targetSum,0,res,path);

        return res;
    }

    private void dfs(TreeNode root, int targetSum, int i, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        int s = (i+root.val);
        path.add(root.val);

        if (root.left == null && root.right == null && s == targetSum) {
            List<Integer> t = new LinkedList<>();
            t.addAll(path);
            res.add(t);
            return;
        }

        if (s>targetSum) return;
        dfs(root.left,targetSum,s,res,path);
        dfs(root.right,targetSum,s,res,path);
        path.remove(path.size()-1);
    }
}
