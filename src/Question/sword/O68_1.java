package Question.sword;

import Question.leetcode.common.TreeNode;

public class O68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if ((root.val == p.val || root.val == q.val)
                || (root.val >p.val && root.val <q.val)
                || (root.val <p.val && root.val >q.val)){
            return root;
        }else if (p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }

    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;

        while (true){
            if (p.val < ancestor.val && q.val <ancestor.val){
                ancestor = ancestor.left;
            }else if (p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else {
                break;
            }
        }
        return ancestor;
    }

}
