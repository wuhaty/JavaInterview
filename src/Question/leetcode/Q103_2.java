package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q103_2 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res,root,0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int i) {
        if (root == null) return;

        if (i == res.size()){
            res.add(new LinkedList<>());
        }

        if (i %2 ==0){
            res.get(i).add(root.val);
        }else {
            res.get(i).add(0,root.val);
        }

        helper(res,root.left,i+1);
        helper(res,root.right,i+1);
    }


}
