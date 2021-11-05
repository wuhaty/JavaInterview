package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/11.
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null){
            return left.val == right.val && isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
        }else if(left == null && right == null){
            return true;
        }else {
            return false;
        }
    }
}
