package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2018/4/9.
 */
public class Q814 {
    public TreeNode pruneTree(TreeNode root) {
        TreeNode res = new TreeNode(root.val);

        helper(root);
        return null;
    }

    private boolean helper(TreeNode root) {
        if (root==null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (root.val !=1 && left && right){
            return true;
        }else {
            return false;
        }
    }
}
