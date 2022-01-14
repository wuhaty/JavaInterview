package Question.sword;

import Question.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class O34 {
    List<Integer> l = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,0,target);
        return res;
    }

    private void dfs(TreeNode root, int sum, int target) {
        if (root == null) return;

        sum += root.val;
        l.add(root.val);

        if (sum == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(l));
        }

        dfs(root.left,sum,target);
        dfs(root.right,sum,target);
        l.remove(l.size()-1);
    }
}
