package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right != null) return root;
        return left ==null? right:left;
    }

    public TreeNode lowestCommonAncestor2020(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;


        TreeNode left = lowestCommonAncestor2020(root.left, p,q);
        TreeNode right = lowestCommonAncestor2020(root.right, p,q);

        if (left!=null && right != null) return root;

        return left==null?right:left;
    }

    public TreeNode lowestCommonAncestor2021(TreeNode root, TreeNode p, TreeNode q) {
        boolean inCurrent = (root == p || root == q);
        if (root == null || inCurrent) return root;


        TreeNode inLeft = lowestCommonAncestor2021(root.left,p,q);
        TreeNode inRight = lowestCommonAncestor2021(root.right,p,q);

        if (inLeft != null && inRight!=null) {
            return root;
        }

        return (inLeft == null)? inRight:inLeft;
    }

    public TreeNode lowestCommonAncestor2021_2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode inLeft = lowestCommonAncestor2021_2(root.left,p,q);
        TreeNode inRight = lowestCommonAncestor2021_2(root.right,p,q);

        if (inLeft != null && inRight != null){
            return root;
        }

        return inLeft == null? inRight:inLeft;
    }
}
