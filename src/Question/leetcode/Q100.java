package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2017/9/23.
 */
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if ((p == null && q!=null) || (p!=null && q==null)) return false;

        if (p.val==q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else
            return false;
    }

    public boolean isSameTree2020(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;


        if (p != null && q!= null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree2020(p.left,q.left) && isSameTree2020(p.right,q.right);
        }

        return false;
    }
}
