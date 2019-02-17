package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
