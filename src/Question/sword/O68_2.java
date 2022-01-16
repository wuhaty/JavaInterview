package Question.sword;

import Question.leetcode.common.TreeNode;

public class O68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode inLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode inRight = lowestCommonAncestor(root.left,p,q);
        if (inLeft!=null && inRight!=null) return root;

        return inLeft==null?inRight:inLeft;
    }
}
