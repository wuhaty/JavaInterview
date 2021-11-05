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
}
