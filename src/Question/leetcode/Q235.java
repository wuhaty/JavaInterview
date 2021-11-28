package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/17.
 */
public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {

            if (root.val == p.val || root.val == q.val){
                return root;
            }

            if ((p.val > root.val && q.val< root.val) || (root.val < q.val && root.val > p.val)){
                return root;
            }

            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }

            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
        }
    }

    public TreeNode lowestCommonAncestor2021(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode inLeft = lowestCommonAncestor2021(root.left,p,q);
        TreeNode inRight = lowestCommonAncestor2021(root.right,p,q);

        if (inLeft != null && inRight !=null) {
            return root;
        }

        return inLeft == null?inRight:inLeft;
    }

    public TreeNode lowestCommonAncestorOpt(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if (root.val> p.val && root.val > q.val){
                root = root.left;
            }else if(root.val<p.val && root.val <q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
}
