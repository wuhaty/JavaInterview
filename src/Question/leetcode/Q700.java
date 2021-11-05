package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/4/22.
 */
public class Q700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        else if (root.val<val) {
            return searchBST(root.right,val);
        }else {
            return searchBST(root.left,val);
        }
    }
}
