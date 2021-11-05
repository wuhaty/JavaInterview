package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/14.
 */
public class Q669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val>= low && root.val<= high) {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }else if (root.val<low){
            return trimBST(root.right,low,high);
        }else {
            return trimBST(root.left,low,high);
        }

        return root;
    }
}
