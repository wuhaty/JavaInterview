package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/17.
 */
public class Q1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return root;

        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);

        if (root.val == target && root.left == null && root.right == null){
            return null;
        }

        return root;
    }
}
