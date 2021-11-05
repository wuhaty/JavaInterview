package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/6/13.
 */
public class Q1448 {

    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return count;
    }

    private void helper(TreeNode root, int max) {
        if (root == null) return;

        int val = root.val;
        if (val >= max) {
            count++;
        }
        max = Math.max(max,val);
        helper(root.left,max);
        helper(root.right,max);
    }
}
