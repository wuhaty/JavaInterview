package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/14.
 */
public class Q572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root ==null) return false;

        return isSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }


    public boolean isSame(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p== null || q == null) return false;

        if (p.val == q.val) {
            return isSame(p.left,q.left) && isSame(p.right,q.right);
        }

        return false;
    }
}
